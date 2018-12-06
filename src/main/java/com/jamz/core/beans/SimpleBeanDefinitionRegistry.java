package com.jamz.core.beans;

import com.jamz.core.beans.factory.BeanFactory;
import com.jamz.utils.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry,BeanFactory {
    private final Map<String,BeanDefinition> registry = new ConcurrentHashMap<>();

    @Override
    public Map<String, BeanDefinition> getRegistry() {
        return this.registry;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition){
        Assert.isNotBlank(beanName,"beanName must not be empty");
        Assert.isNotNull(beanDefinition,"beanDefinition must not be null");
        this.registry.put(beanName,beanDefinition);
    }

    @Override
    public Object getBean(String name) {
        BeanDefinition beanDefinition = this.registry.get(name);
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
