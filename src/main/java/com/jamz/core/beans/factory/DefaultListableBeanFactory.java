package com.jamz.core.beans.factory;

import com.jamz.core.beans.BeanDefinition;
import com.jamz.core.beans.BeanDefinitionRegistry;

import java.util.Map;

public class DefaultListableBeanFactory implements BeanDefinitionRegistry {
    @Override
    public Map<String, BeanDefinition> getRegistry() {
        return null;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {

    }
}
