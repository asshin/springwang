package com.wang.springframework.beans.factory.config;

/**
 * @author zsw
 * @create 2022-07-28 15:15
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String BeanName);
}
