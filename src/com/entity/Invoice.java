package com.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table
public class Invoice {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO) 	
	private int invoiceNo;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date invoiceDate;
	private Long projectNumber;
	private String totalAmountDue;

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
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
