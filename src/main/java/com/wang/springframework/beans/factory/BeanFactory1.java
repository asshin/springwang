package com.wang.springframework.beans.factory;

import com.wang.springframework.beans.factory.config.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zsw
 * @create 2022-07-28 14:27
 */
public class BeanFactory1 {
    private ConcurrentHashMap beanDefinitionMap;

    public BeanFactory1() {
        beanDefinitionMap=new ConcurrentHashMap<String,Object>();
    }

    public Object getBean(String beanName) throws IllegalAccessException, InstantiationException {
        BeanDefinition definition = (BeanDefinition)beanDefinitionMap.get(beanName);
        return definition.getaClass().newInstance();
    }
    public void registerBeanDefinition(String beanName,Object o){
        beanDefinitionMap.put(beanName,o);
    }

}
