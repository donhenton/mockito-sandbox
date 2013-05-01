package com.dhenton9000.mockito.sandbox;

import java.util.ArrayList;
import java.util.List;
import javax.security.auth.login.LoginException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.BDDMockito.*;

/**
 * Unit test for simple App.
 */
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    public static final String GARBAGE = "GARBAGE";
    public static final String NAME = "FRED";
    public static final String PASSWORD = "PASSWORD";
    User user1 = null;
    private final Logger logger = LoggerFactory.getLogger(AppTest.class);
    private MailDownloadingService service = new MailDownloadingServiceImpl();
    private static final String BODY_STRING = "body";
    @Mock
    private MailDao dao;
    private List<MailMessage> unfilteredHeaders;

    @Before
    public void assembleService() {
        ((MailDownloadingServiceImpl) service).setMailDao(dao);
        unfilteredHeaders = new ArrayList<MailMessage>();
        MailMessage mMessage = new MailMessage();
        mMessage.setSubject(BODY_STRING);
        mMessage.setSubject(GARBAGE);
        mMessage.setHeaderId(5);
        unfilteredHeaders.add(mMessage);
        mMessage = new MailMessage();
        mMessage.setSubject("TED");
        mMessage.setSubject("FRED");
        mMessage.setHeaderId(12);
        unfilteredHeaders.add(mMessage);

        user1 = new User();
        user1.setName(NAME);
        user1.setPassword(PASSWORD);
 
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    @Test
    public void testMailBodyForIdGood() {
        Integer i = new Integer(5);
        MailMessage mMessage = new MailMessage();
        mMessage.setBody(BODY_STRING);
        given(dao.getMessageForId(i)).willReturn(mMessage);
        String body = service.getMailBodyForId(i, null);
        assertEquals(BODY_STRING, body);


    }

    @Test
    public void testMailBodyForIdBad() {
        Integer i = new Integer(5);
        MailMessage mMessage = new MailMessage();
        mMessage.setBody(BODY_STRING);
        given(dao.getMessageForId(new Integer(i))).willReturn(mMessage, (MailMessage) null);
        String body = service.getMailBodyForId(i, null);
        assertEquals(BODY_STRING, body);
        body = service.getMailBodyForId(6, null);
        assertNull(body);


    }

    @Test
    public void testFilterWorks() {
        Integer i = new Integer(5);
        MailMessage mMessage = new MailMessage();
        mMessage.setSubject(BODY_STRING);
        mMessage.setBody(BODY_STRING + "X");
        given(dao.getMessageForId(new Integer(i))).willReturn(mMessage);
        String body = service.getMailBodyForId(i, BODY_STRING);
        assertEquals(BODY_STRING + "X", body);

    }

    @Test
    public void testFilterFiltersOut() {
        Integer i = new Integer(5);
        MailMessage mMessage = new MailMessage();
        mMessage.setSubject(BODY_STRING);
        mMessage.setSubject(GARBAGE);
        given(dao.getMessageForId(new Integer(i))).willReturn(mMessage);
        String body = service.getMailBodyForId(i, BODY_STRING);
        assertEquals(null, body);

    }

    @Test
    public void testMailSubjectsWithOutFilter() {

        given(dao.getAllMailMessages()).willReturn(unfilteredHeaders);
        List<String> things = service.getMailSubjects(null);
        assertEquals(unfilteredHeaders.size(), things.size());


    }

    @Test
    public void testMailSubjectsWithFilter() {

        given(dao.getAllMailMessages()).willReturn(unfilteredHeaders);
        List<String> things = service.getMailSubjects(GARBAGE);
        assertEquals(unfilteredHeaders.size() - 1, things.size());


    }

    @Test
    public void testGetMailIdsWithFilter() {

        given(dao.getAllMailMessages()).willReturn(unfilteredHeaders);
        List<Integer> things = service.getMailIds(GARBAGE);
        assertEquals(unfilteredHeaders.size() - 1, things.size());


    }

    @Test
    public void testGetMailIdsWithOutFilter() {

        given(dao.getAllMailMessages()).willReturn(unfilteredHeaders);
        List<Integer> things = service.getMailIds(null);
        assertEquals(unfilteredHeaders.size(), things.size());


    }

    @Test(expected = LoginException.class)
    public void testUserAccountNotFound() throws Exception {

        given(dao.hasAccount(user1)).willReturn(false);
        User u = service.authenticate(user1);
    }

    @Test 
    public void testUserAccount() throws Exception {

        assertFalse(user1.isOkay());
        given(dao.hasAccount(user1)).willReturn(true);
        User u = service.authenticate(user1);
        assertEquals(u, user1);
        assertTrue(u.isOkay());

    }
}
