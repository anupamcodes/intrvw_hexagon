package com.anupam.tiaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.anupam.dto.ResultBranchDetailType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    //All Match
    public void testApp1()
    {
    	String args[] = {"C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\input1"};
    	App.main(args);
    	
    	try (Stream<Path> paths = Files.walk(Paths.get("C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\output\\match.json"))) {
    	List<File> filesInFolder = paths.filter(Files::isRegularFile).map(Path::toFile)
				.collect(Collectors.toList());
    	for (File file : filesInFolder) {
			ObjectMapper objectMapper = new ObjectMapper();
			InputStream is = new FileInputStream(file);
			List<ResultBranchDetailType> fcType = objectMapper.readValue(is, List.class);
			assertEquals(2, fcType.size());
		}
    	} catch (Exception e){
    		e.printStackTrace();
    	}
        
    }
    
    //All Mismatch
    public void testApp2()
    {
    	String args[] = {"C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\input2"};
    	App.main(args);
    	
    	try (Stream<Path> paths = Files.walk(Paths.get("C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\output\\mismatch.json"))) {
    	List<File> filesInFolder = paths.filter(Files::isRegularFile).map(Path::toFile)
				.collect(Collectors.toList());
    	for (File file : filesInFolder) {
			ObjectMapper objectMapper = new ObjectMapper();
			InputStream is = new FileInputStream(file);
			List<ResultBranchDetailType> fcType = objectMapper.readValue(is, List.class);
			assertEquals(2, fcType.size());
		}
    	} catch (Exception e){
    		e.printStackTrace();
    	}
        
    }
    
    //One Match One Mismatch
    public void testApp3()
    {
    	String args[] = {"C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\input3"};
    	App.main(args);
    	
    	try (Stream<Path> paths = Files.walk(Paths.get("C:\\Users\\Anupam\\workspace\\tiaa\\src\\test\\output"))) {
    	List<File> filesInFolder = paths.filter(Files::isRegularFile).map(Path::toFile)
				.collect(Collectors.toList());
    	for (File file : filesInFolder) {
			ObjectMapper objectMapper = new ObjectMapper();
			InputStream is = new FileInputStream(file);
			List<ResultBranchDetailType> fcType = objectMapper.readValue(is, List.class);
			assertEquals(1, fcType.size());
		}
    	} catch (Exception e){
    		e.printStackTrace();
    	}
        
    }
    
}
