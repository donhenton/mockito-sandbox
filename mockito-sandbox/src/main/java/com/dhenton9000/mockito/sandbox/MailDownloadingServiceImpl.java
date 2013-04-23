/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mockito.sandbox;

import java.util.ArrayList;
import java.util.List;
import javax.security.auth.login.LoginException;

/**
 *
 * @author dhenton
 */
public class MailDownloadingServiceImpl implements MailDownloadingService {

    private MailDao mailDao = null;

    public List<String> getMailSubjects(String filter) {
        List<MailMessage> unfilteredHeaders = getMailDao().getAllMailMessages();
        ArrayList<String> filteredSubjects = new ArrayList<String>();
        for (MailMessage t : unfilteredHeaders) {

            if (filter != null) {
                if (t.getSubject().contains(filter)) {
                    filteredSubjects.add(t.getSubject());
                }
            } else {
                filteredSubjects.add(t.getSubject());
            }
        }
        return filteredSubjects;

    }

    public List<Integer> getMailIds(String filter) {
        List<MailMessage> unfilteredHeaders = getMailDao().getAllMailMessages();
        ArrayList<Integer> filteredIds = new ArrayList<Integer>();
        for (MailMessage t : unfilteredHeaders) {

            if (filter != null) {
                if (t.getSubject().contains(filter)) {
                    filteredIds.add(t.getHeaderId());
                }
            } else {
                filteredIds.add(t.getHeaderId());
            }
        }
        return filteredIds;

    }

    public String getMailBodyForId(Integer id, String filter) {
        String t = null;
        MailMessage m = getMailDao().getMessageForId(id);
        if (m == null) {
            return null;
        }
        if (filter != null) {
            if (m.getSubject().contains(filter)) {
                t = m.getBody();
            }
        } else {
            t = m.getBody();
        }

        return t;
    }

    public User authenticate(User u) throws LoginException {
        User uPerson = null;
        if (mailDao.hasAccount(u))
        {
            return u;
        }        
        return uPerson;
    }

    /**
     * @return the mailDao
     */
    public MailDao getMailDao() {
        return mailDao;
    }

    /**
     * @param mailDao the mailDao to set
     */
    public void setMailDao(MailDao mailDao) {
        this.mailDao = mailDao;
    }
}
