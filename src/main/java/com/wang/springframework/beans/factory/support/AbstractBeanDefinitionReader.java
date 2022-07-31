package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.factory.config.BeanDefinition;
import com.wang.springframework.core.io.DefaultResourceLoader;
import com.wang.springframework.core.io.ResourceLoader;

/**
 * @author zsw
 * @create 2022-07-29 20:38
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }


    public BeanDefinitionRegistry getRegistry(){
        return registry;
    }
    public ResourceLoader getResourceLoader(){

        return resourceLoader;
    }



}
