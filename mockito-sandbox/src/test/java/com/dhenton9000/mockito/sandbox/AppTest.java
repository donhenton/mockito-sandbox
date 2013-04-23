package com.dhenton9000.mockito.sandbox;

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

    private final Logger logger = LoggerFactory.getLogger(AppTest.class);
    private MailDownloadingServiceImpl service = new MailDownloadingServiceImpl();
    private static final String BODY_STRING = "body";
    @Mock
    private MailDao dao;

    @Before
    public void assembleService() {
        service.setMailDao(dao);
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
        mMessage.setBody(BODY_STRING+"X");
        given(dao.getMessageForId(new Integer(i))).willReturn(mMessage);
        String body = service.getMailBodyForId(i, BODY_STRING);
        assertEquals(BODY_STRING+"X", body);

    }

    @Test
    public void testFilterFiltersOut() {
        Integer i = new Integer(5);
        MailMessage mMessage = new MailMessage();
        mMessage.setSubject(BODY_STRING);
        mMessage.setSubject("GARBAGE");
        given(dao.getMessageForId(new Integer(i))).willReturn(mMessage);
        String body = service.getMailBodyForId(i, BODY_STRING);
        assertEquals(null, body);

    }
}
