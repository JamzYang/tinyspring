package com.jamz.core.beans.factory;

import com.jamz.core.beans.BeanDefinition;
import com.jamz.core.beans.XmlBeanDefinitionReader;
import com.jamz.core.io.Resource;
import com.jamz.utils.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XmlBeanFactory extends DefaultListableBeanFactory {
    //ToDo
    //源码 将this (本类)做参数传给 XmlBeanDefinitionReader的构造方法. 暂时不明白为什么,后续弄明白
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    public XmlBeanFactory(Resource resource){
        try {
            reader.loadBeanDefinitions(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanName){
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        Assert.isNotNull(beanDefinition,"No bean named"+beanName+" is defined");
//        beanDefinition.
        return null;
    }
}
