/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mockito.sandbox;

import com.sun.security.auth.UserPrincipal;
import java.util.List;
import javax.security.auth.login.LoginException;

/**
 *
 * @author dhenton
 */
public interface MailDownloadingService {
    
    List<String> getMailSubjects(String filter);
    List<Integer> getMailIds(String filter);
    String getMailBodyForId(Integer id,String filter);
    User authenticate(UserPrincipal u) throws LoginException;
}
