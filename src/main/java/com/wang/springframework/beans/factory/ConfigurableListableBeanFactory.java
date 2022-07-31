package com.wang.springframework.beans.factory;

import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.wang.springframework.beans.factory.config.BeanDefinition;
import com.wang.springframework.beans.factory.config.BeanPostProcessor;
import com.wang.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author zsw
 * @create 2022-07-30 11:03
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory{

    BeanDefinition getBeanDefinition(String beanName)  ;

    void preInstantiateSingletons()    ;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
