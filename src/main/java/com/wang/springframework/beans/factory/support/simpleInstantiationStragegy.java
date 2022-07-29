package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author zsw
 * @create 2022-07-28 16:23
 */
public class simpleInstantiationStragegy implements InstantiationStrategy {
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws NoSuchMethodException {
        try {
            if(constructor==null){
                return beanDefinition.getaClass().newInstance();
            }else {
                return  constructor.newInstance(args);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
