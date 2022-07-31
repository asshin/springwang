package com.wang.springframework.beans.factory.config;

import com.wang.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author zsw
 * @create 2022-07-30 10:46
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
