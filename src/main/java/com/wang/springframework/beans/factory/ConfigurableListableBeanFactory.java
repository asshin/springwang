package com.wang.springframework.beans.factory;

import com.wang.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zsw
 * @create 2022-07-30 11:03
 */
public interface ConfigurableListableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName);
}
