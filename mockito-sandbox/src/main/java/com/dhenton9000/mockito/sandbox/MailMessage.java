/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mockito.sandbox;

/**
 *
 * @author dhenton
 */
public class MailMessage {
    private int headerId;
    private String subject;
    private String body;

    /**
     * @return the headerId
     */
    public int getHeaderId() {
        return headerId;
    }

    /**
     * @param headerId the headerId to set
     */
    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }
}
