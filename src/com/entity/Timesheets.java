/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;

/**
 *
 * @author Mantu
 */
@Entity
@IdClass(value=TimesheetCK.class)
public class Timesheets implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private String userId;
    @Id
    private int project;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Id
    private Date date;
    private int duration;
    private boolean approved;
    private String approvedBy;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedOn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(Date approvedOn) {
        this.approvedOn = approvedOn;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timesheets)) {
            return false;
        }
        Timesheets other = (Timesheets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Timesheets[ id=" + id + " ]";
    }
    
}
