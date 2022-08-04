package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zsw
 * @create 2022-07-28 15:16
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private  ConcurrentHashMap singletonMap;
           Object NULL_OBJECT;
    public DefaultSingletonBeanRegistry() {
        singletonMap=new ConcurrentHashMap<String,Object>();
    }

    public Object getSingleton(String BeanName) {
        Object bean = singletonMap.get(BeanName);
        return bean;
    }
    public void  addSingleton(String BeanName,Object bean){
        this.singletonMap.put(BeanName,bean);
    }
}
