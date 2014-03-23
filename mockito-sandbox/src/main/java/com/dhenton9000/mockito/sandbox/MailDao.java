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
public interface MailDao {
    List<MailMessage> getAllMailMessages();
    MailMessage getMessageForId(Integer id);
    boolean hasAccount(User  principal);
    void performAudit(AuditModel model);
}
