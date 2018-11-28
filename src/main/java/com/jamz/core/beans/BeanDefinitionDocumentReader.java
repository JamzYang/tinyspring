package com.jamz.core.beans;

import com.jamz.core.io.Resource;
import org.w3c.dom.Document;

public interface BeanDefinitionDocumentReader {

    void RegisterBeanDefinition(Document doc,Resource res);
}
