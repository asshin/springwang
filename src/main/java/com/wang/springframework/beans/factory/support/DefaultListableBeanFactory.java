package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.factory.config.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zsw
 * @create 2022-07-28 15:32
 */
public class DefaultListableBeanFactory extends  AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private ConcurrentHashMap BeanDefinitionMap=new ConcurrentHashMap<String,BeanDefinition>();
    public BeanDefinition getBeanDefinition(String BeanDefinitonName) {
        return (BeanDefinition) BeanDefinitionMap.get(BeanDefinitonName);
    }
    public void RegistryBeanDefinition(String BeanDefinitionName, BeanDefinition beanDefinition) {
    BeanDefinitionMap.put(BeanDefinitionName,beanDefinition);
    }
}
