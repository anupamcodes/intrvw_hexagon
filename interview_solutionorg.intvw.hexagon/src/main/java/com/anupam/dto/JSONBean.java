//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.04 at 04:19:10 PM IST 
//


package com.anupam.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * <p>Java class for branchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="branchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalcollection" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="locationid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jsonBean", propOrder = {
    "cmfoodchain"
})
public class JSONBean {

    @XmlElement(required = true)
    protected CmfoodchainType cmfoodchain;

    @JsonGetter("cmfoodchain")
	public CmfoodchainType getCmFoodChain() {
		return cmfoodchain;
	}

    @JsonSetter("cmfoodchain")
	public void setCmFoodChain(CmfoodchainType cmfoodchain) {
		this.cmfoodchain = cmfoodchain;
	}

}
