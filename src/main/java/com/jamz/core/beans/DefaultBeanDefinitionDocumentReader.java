package com.jamz.core.beans;

import com.jamz.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Map;

/**
 * @deprecated
 * 此类暂不使用
 */
public class DefaultBeanDefinitionDocumentReader implements BeanDefinitionDocumentReader {
    public static final String BEAN_ELEMENT = "bean";
    @Override
    public void RegisterBeanDefinition(Document doc, Resource res) {
        Element root = doc.getDocumentElement();
        if(!root.getNodeName().equals(BEAN_ELEMENT)){
            throw new IllegalArgumentException("The"+root+"element has not implement yet");
        }
        parseBeanDefinitionElement(root);

    }


    protected void parseBeanDefinitionElement(Element root){
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            Element ele = (Element)node;
            processBeanDefinition(ele);
        }

    }

    private void processBeanDefinition(Element ele) {
        String beanName = ele.getAttribute("id");
        String beanClassName = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
    }


}
