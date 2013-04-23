/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mockito.sandbox;

/**
 *
 * @author dhenton
 */
public class User {
    private String name = null;
    private String password = null;
    private boolean okay = false;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the okay
     */
    public boolean isOkay() {
        return okay;
    }

    /**
     * @param okay the okay to set
     */
    public void setOkay(boolean okay) {
        this.okay = okay;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", okay=" + okay + '}';
    }
    
    
    
    
}
