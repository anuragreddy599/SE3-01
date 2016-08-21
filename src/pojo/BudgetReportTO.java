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
public class BudgetReportTO {
    private Long clientId;
    private String clientName;
    private Long projectId;
    private String projectName;
    private Long totalBudget ;
    private Long budgetRemaining;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Long totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Long getBudgetRemaining() {
        return budgetRemaining;
    }

    public void setBudgetRemaining(Long budgetRemaining) {
        this.budgetRemaining = budgetRemaining;
    }

    
    
    
}
