package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zsw
 * @create 2022-07-28 15:27
 */
public interface BeanDefinitionRegistry {
    void RegistryBeanDefinition(String BeanDefinitionName, BeanDefinition beanDefinition);
}
