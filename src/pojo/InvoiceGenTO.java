/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

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
