//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.04 at 04:19:10 PM IST 
//


package com.anupam.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderdetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderdetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderid" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="billamount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderdetailType", propOrder = {
    "orderid",
    "billamount"
})
public class OrderdetailType {

    protected int orderid;
    protected float billamount;

    /**
     * Gets the value of the orderid property.
     * 
     */
    public int getOrderid() {
        return orderid;
    }

    /**
     * Sets the value of the orderid property.
     * 
     */
    public void setOrderid(int value) {
        this.orderid = value;
    }

    /**
     * Gets the value of the billamount property.
     * 
     */
    public float getBillamount() {
        return billamount;
    }

    /**
     * Sets the value of the billamount property.
     * 
     */
    public void setBillamount(float value) {
        this.billamount = value;
    }

}
