/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Mantu
 */
public class LineItemTO {
    private String invoiceNo; 
    private String invoiceLineItemNo;
	private String date;
	private String description;
	private int rate;
	private int hours;
	private int amount;

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

        
    public String getInvoiceLineItemNo() {
        return invoiceLineItemNo;
    }

    public void setInvoiceLineItemNo(String invoiceLineItemNo) {
        this.invoiceLineItemNo = invoiceLineItemNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
        
        
}
