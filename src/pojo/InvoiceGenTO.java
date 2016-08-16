/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mantu
 */
public class InvoiceGenTO {
    private Long client;
    private Map<Long,List<TimesheetTO>> timeSheets;
    private List<Long> projectList;
    
    private String invoiceFreq;
    private Date lastInvoiceDate;

    public String getInvoiceFreq() {
        return invoiceFreq;
    }

    public void setInvoiceFreq(String invoiceFreq) {
        this.invoiceFreq = invoiceFreq;
    }

    public Date getLastInvoiceDate() {
        return lastInvoiceDate;
    }

    public void setLastInvoiceDate(Date lastInvoiceDate) {
        this.lastInvoiceDate = lastInvoiceDate;
    }
    

    public Map<Long, List<TimesheetTO>> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(Map<Long, List<TimesheetTO>> timeSheets) {
        this.timeSheets = timeSheets;
    }

   

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public List<Long> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Long> projectList) {
        this.projectList = projectList;
    }
    
    
}
