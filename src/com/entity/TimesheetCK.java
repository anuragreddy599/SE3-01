/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/**
 *
 * @author Mantu
 */
@Embeddable
public class TimesheetCK implements Serializable {
    private String userId;
    private int project;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.userId);
        hash = 17 * hash + this.project;
        hash = 17 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimesheetCK other = (TimesheetCK) obj;
        return true;
    }
}
