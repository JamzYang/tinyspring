package com.jamz.core.beans;

import com.jamz.core.io.Resource;

import java.util.HashMap;
import java.util.Map;

public abstract class DefaultBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

    private Resource resource;

    public DefaultBeanDefinitionReader() {
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
