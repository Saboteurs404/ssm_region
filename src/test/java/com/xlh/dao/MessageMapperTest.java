package com.xlh.dao;

import com.xlh.entity.Message;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static  org.junit.Assert.*;

/**
 * @author Xlh
 * @create 2022-06-25 20:42
 */

public class MessageMapperTest extends TestCase {

    private ApplicationContext applicationContext;

    @Autowired
    private MessageMapper mapper;

    @Before
    public void setUp() throws Exception {
        //加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring.applicationContext,xml");
        //导入需要测试的
        mapper= applicationContext.getBean(MessageMapper.class);
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInsert() {
        Message message=new Message();
        message.setCommand("吃饭");
        message.setContent("睡觉");
        message.setDescription("打豆豆");
        int result = mapper.insert(message);
        System.out.println(result);
        assert (result == 1);

    }
}