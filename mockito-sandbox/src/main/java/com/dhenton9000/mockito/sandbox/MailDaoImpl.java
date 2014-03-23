/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mockito.sandbox;

import java.util.List;

/**
 *
 * @author dhenton
 */
public class MailDaoImpl implements MailDao {

    public List<MailMessage> getAllMailMessages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MailMessage getMessageForId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean hasAccount(User principal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void performAudit(AuditModel model) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    
    
}
