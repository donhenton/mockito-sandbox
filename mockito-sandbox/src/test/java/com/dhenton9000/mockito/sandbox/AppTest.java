package com.dhenton9000.mockito.sandbox;

import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
 
/**
 * Unit test for simple App.
 */
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    private final Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    /**
     */
    @Test
    public void testApp() {
        logger.debug("geta job");
        assertTrue(true);
    }
}
