package com.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Invoice {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO) 	
	private String invoiceNo;
	private Date invoiceDate;
	private Long projectNumber;
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

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Long getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Long projectNumber) {
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
