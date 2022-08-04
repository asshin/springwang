package com.wang.springframework.beans.factory.config;

import com.wang.springframework.beans.BeansException;

/**
 * @author zsw
 * @create 2022-07-30 10:45
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException;
    Object postProcessAfterInitialization(Object bean,String beanName);
}
