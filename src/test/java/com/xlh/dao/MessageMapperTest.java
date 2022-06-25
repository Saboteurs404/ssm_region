package com.xlh.dao;

import junit.framework.TestCase;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author Xlh
 * @create 2022-06-25 20:42
 */

public class MessageMapperTest extends TestCase {

    private ApplicationContext applicationcontext;

    @Autowired
    private MessageMapper mapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testInsert() {
    }
}