/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mockito.sandbox;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import javax.annotation.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author dhenton
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mockito-spring.xml")
public class DaoTests {
    
    
    @Resource
    private JavaMailSender emailService;
    private GreenMail greenMail;
    private final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Before
    public void startMailServer() {
        greenMail = new GreenMail(ServerSetupTest.POP3);
        greenMail.start();
    }

    @After
    public void stopMailServer() {
        greenMail.stop();
    }
    
    
    
}
