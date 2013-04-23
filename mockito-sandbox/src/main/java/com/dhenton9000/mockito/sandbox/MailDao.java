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
    List<String> getMailHeaders();
    List<Integer> getMailIds();
    String getMailBodyForId(Integer id);
    boolean hasAccount(User  principal);
}
