package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Client {

	 @Id
	   @GeneratedValue(strategy = GenerationType.AUTO) 	
	 private int number;
	 private String name;
	 private String addressLine1;
	 private String addressLine2;
	 private String city;
	 private String state;
	 private String zip;
	 private String email;
	 private String contact;
	 private String invoiceFreq;
	 private String billingTerms;
	 private String invoiceGrouping;
	 private String status;	 
	 
	 /**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the invoiceFreq
	 */
	public String getInvoiceFreq() {
		return invoiceFreq;
	}

	/**
	 * @param invoiceFreq the invoiceFreq to set
	 */
	public void setInvoiceFreq(String invoiceFreq) {
		this.invoiceFreq = invoiceFreq;
	}

	/**
	 * @return the billingTerm
	 */
	public String getBillingTerm() {
		return billingTerms;
	}

	/**
	 * @param billingTerm the billingTerm to set
	 */
	public void setBillingTerm(String billingTerm) {
		this.billingTerms = billingTerm;
	}

	/**
	 * @return the invoiceGrouping
	 */
	public String getInvoiceGrouping() {
		return invoiceGrouping;
	}

	/**
	 * @param invoiceGrouping the invoiceGrouping to set
	 */
	public void setInvoiceGrouping(String invoiceGrouping) {
		this.invoiceGrouping = invoiceGrouping;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public enum Frequency {
	        WEEKLY("Weekly"), MONTHLY("Monthly"), BI_WEEKLY ("BiWeekly");

	        private String value;

	        Frequency(String value) { this.value = value; }    

	        public String getValue() { return value; }

	        public static Frequency parse(String id) {
	        	Frequency freq = null; // Default
	            for (Frequency item : Frequency.values()) {
	                if (item.getValue()==id) {
	                	freq = item;
	                    break;
	                }
	            }
	            return freq;
	        }

	    };
}



