package com.jamz.core.beans;

import com.jamz.utils.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanDefinitionRegistry {
     Map<String,BeanDefinition> getRegistry();
     void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);
}
