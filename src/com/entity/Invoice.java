package com.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Invoice {

	private String invoiceNo;
	private String invoiceDate;
	private String projectNumber;
	private String totalAmountDue;
	/**
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * @return the invoiceDate
	 */
	public String getInvoiceDate() {
		return invoiceDate;
	}
	/**
	 * @param invoiceDate the invoiceDate to set
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	/**
	 * @return the projectNumber
	 */
	public String getProjectNumber() {
		return projectNumber;
	}
	/**
	 * @param projectNumber the projectNumber to set
	 */
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	/**
	 * @return the totalAmountDue
	 */
	public String getTotalAmountDue() {
		return totalAmountDue;
	}
	/**
	 * @param totalAmountDue the totalAmountDue to set
	 */
	public void setTotalAmountDue(String totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}
}
