/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.mockito.sandbox;

import java.util.Date;

/**
 *
 * @author Don
 */
public class AuditModel {
    private String filter;
    private Date auditDate = null;

    String getFilter() {
        return this.filter; 
    }
    
    public void setFilter(String t)
    {
        this.filter = t;
    }

    /**
     * @return the auditDate
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * @param auditDate the auditDate to set
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
    
}
