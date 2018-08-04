package com.anupam.tiaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.anupam.dto.CmfoodchainType;
import com.anupam.dto.JSONBean;
import com.anupam.dto.OrderdetailType;
import com.anupam.dto.ResultBranchDetailType;
import com.anupam.dto.ResultCmFoodChain;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class TiaaEngine {
	static Logger log = Logger.getLogger(TiaaEngine.class.getName());
	ResultCmFoodChain match ;
	ResultCmFoodChain mismatch ;
	List<ResultBranchDetailType> branchDetailListMatch;
	List<ResultBranchDetailType> branchDetailListMismatch;
	String inputPath;

	public TiaaEngine(String inputPath) {
		this.inputPath = inputPath;
	}

	public void process() {
		match = new ResultCmFoodChain();
		mismatch = new ResultCmFoodChain();
		branchDetailListMatch = new ArrayList<>();
		branchDetailListMismatch = new ArrayList<>();
		
		try (Stream<Path> paths = Files.walk(Paths.get(this.inputPath))) {
			List<File> filesInFolder = paths.filter(Files::isRegularFile).map(Path::toFile)
					.collect(Collectors.toList());
			CmfoodchainType fcType = null;
			for (File file : filesInFolder) {
				ResultBranchDetailType branchDetail = new ResultBranchDetailType();
				ObjectMapper objectMapperXml = new XmlMapper();
				ObjectMapper objectMapper = new ObjectMapper();
				InputStream is = new FileInputStream(file);

				if (file.getName().contains("xml")) {
					fcType = objectMapperXml.readValue(is, CmfoodchainType.class);
				} else {
					JSONBean jsonBean = objectMapper.readValue(is, JSONBean.class);
					fcType = jsonBean.getCmFoodChain();
				}
				prepareResult(branchDetail, fcType);
				writeResult();
			}
			

		} catch (IOException e) {
			log.error(e.getMessage());

		}

	}

	private void writeResult() {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objMapper.writeValue(
					new FileOutputStream("C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\output\\match.json"), branchDetailListMatch);
		
		objMapper.writeValue(
				new FileOutputStream("C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\output\\mismatch.json"), branchDetailListMismatch);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	private void prepareResult(ResultBranchDetailType branchDetail, CmfoodchainType fcType) {
		if (null != fcType) {
			float totalCollection = fcType.getBranch().getTotalcollection();
			float orderCollection = 0;
			for (OrderdetailType orderDetail : fcType.getOrders().getOrderdetail()) {
				orderCollection += orderDetail.getBillamount();
			}
			
			branchDetail.setLocation(fcType.getBranch().getLocation());
			branchDetail.setLocationid(fcType.getBranch().getLocationid());
			branchDetail.setSumOfOrder(orderCollection);
			branchDetail.setTotalcollection(totalCollection);
			if (orderCollection == totalCollection) {

				branchDetailListMatch.add(branchDetail);
			} else {
				branchDetailListMismatch.add(branchDetail);
			}
		}
	}

}
