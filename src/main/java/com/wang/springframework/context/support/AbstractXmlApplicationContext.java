package com.wang.springframework.context.support;

import com.wang.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wang.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zsw
 * @create 2022-07-30 11:24
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
     protected abstract String[] getConfigLocation();

    protected   void  loadBeanDefinitions(DefaultListableBeanFactory beanFactory){
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocation = getConfigLocation();
       if (configLocation!=null){
           xmlBeanDefinitionReader.loadDefinitions(configLocation);
       }


    }

}
