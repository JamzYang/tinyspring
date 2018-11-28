package com.jamz.core.beans;

import com.jamz.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends DefaultBeanDefinitionReader{
    public static final String BEANS_ELEMENT = "beans";
    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws Exception{
        InputStream inputStream = resource.getInputStream();
        InputSource inputSource = new InputSource(inputStream);
        doLoadBeanDefinitions(inputSource,resource);
    }

    protected void doLoadBeanDefinitions(InputSource inputSource, Resource resource) throws Exception{
        Document doc = doLoadDocument(inputSource,resource);
        registerBeanDefinitions(doc,resource);
    }


    private void registerBeanDefinitions(Document doc, Resource res) {
//        BeanDefinitionDocumentReader beanDefinitionDocumentReader = new DefaultBeanDefinitionDocumentReader();
//        beanDefinitionDocumentReader.RegisterBeanDefinition(doc,res);
        Element root = doc.getDocumentElement();
        if(!root.getNodeName().equals(BEANS_ELEMENT)){
            throw new IllegalArgumentException("The"+root+"element has not implement yet");
        }
        parseBeanDefinitionElement(root);
    }


    private Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document parse = documentBuilder.parse(inputSource);
        return parse;
    }


    protected void parseBeanDefinitionElement(Element root){
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if(node instanceof Element){
                Element ele = (Element)node;
                processBeanDefinition(ele);
            }

        }

    }
    private void processBeanDefinition(Element ele) {
        String beanName = ele.getAttribute("id");
        String beanClassName = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        getRegistry().registerBeanDefinition(beanName,beanDefinition);
    }

}
