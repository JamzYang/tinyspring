package com.jamz.core.beans.factory;

import com.jamz.core.io.ClassPathResource;
import org.junit.Test;

import static org.junit.Assert.*;

public class XmlBeanFactoryTest {
    @Test
    public void getBean() throws Exception {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        bf.getBean("user");
    }

}