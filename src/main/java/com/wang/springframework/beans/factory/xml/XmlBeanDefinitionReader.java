package com.wang.springframework.beans.factory.xml;


import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.PropertyValue;
import com.wang.springframework.beans.factory.PropertyValues;
import com.wang.springframework.beans.factory.config.BeanDefinition;
import com.wang.springframework.beans.factory.config.BeanReference;
import com.wang.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.wang.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.wang.springframework.core.io.Resource;
import com.wang.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zsw
 * @create 2022-07-29 20:45
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    protected XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public void loadDefinitions(Resource resource) {
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadDefinitions(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDefinitions(Resource... resources) {
        for (int i = 0; i < resources.length; i++) {
            try {
                InputStream inputStream = resources[i].getInputStream();
                doLoadDefinitions(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadDefinitions(String location) {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadDefinitions(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadDefinitions(String[] configLocation){
        for (String s : configLocation) {
            loadDefinitions(s);
        }
    }
    public void doLoadDefinitions(InputStream inputStream)   {
        Document document = XmlUtil.readXML(inputStream);
        Element root= document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)) continue;//判断元素
            if (childNodes.item(i).getNodeName()!="bean") continue;

            //解析标签
            Element bean= (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String aClass = bean.getAttribute("class");
            Class<?> clazz = null;
            try {
                clazz = Class.forName(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //优先级id>name
            String beanName= StrUtil.isNotEmpty(id)?id:name;
            if (StrUtil.isEmpty(beanName)){
                beanName=StrUtil.lowerFirst(clazz.getSimpleName());
            }
            NodeList childNodes1 = bean.getChildNodes();
            //定义bean
            BeanDefinition beanDefinition =new BeanDefinition(clazz);
            //读取属性并注入
            NodeList propertys = bean.getChildNodes();
            PropertyValues propertyValues = new PropertyValues();

            for (int j = 0; j < propertys.getLength(); j++) {
                if (propertys.item(j).getNodeName()!="property") continue;
                //解析property
                Element item = (Element) propertys.item(j);
                String attr_name = item.getAttribute("name");
                String value = item.getAttribute("value");
                String ref = item.getAttribute("ref");
                //获取属性引入对象、对象值
                Object object =StrUtil.isEmpty(ref)?value:new BeanReference(ref);
                PropertyValue propertyValue = new PropertyValue(attr_name, object);
                propertyValues.addPropertyValue(propertyValue);
            }
            beanDefinition.setPropertyValues(propertyValues);
            //注册beandefinition
           getRegistry().RegistryBeanDefinition(beanName,beanDefinition);
        }
    }
}
