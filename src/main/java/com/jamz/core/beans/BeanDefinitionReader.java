package com.jamz.core.beans;

import com.jamz.core.io.Resource;

public interface BeanDefinitionReader {
    void loadBeanDefinitions(Resource resource) throws Exception;
}
