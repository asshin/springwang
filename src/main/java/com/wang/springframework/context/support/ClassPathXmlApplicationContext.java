package com.wang.springframework.context.support;

import com.wang.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author zsw
 * @create 2022-07-30 11:24
 */
public class ClassPathXmlApplicationContext  extends AbstractXmlApplicationContext{
    private String[] configLocation;

    public ClassPathXmlApplicationContext() {
    }
/*
从xml文件中加载beanDefinition，并刷新上下文
* */
    public ClassPathXmlApplicationContext(String[] configLocation) throws BeansException {
        this.configLocation=configLocation;
        refresh();
    }
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }


    @Override
    protected String[] getConfigLocation() {
        return configLocation;
    }





    @Override
    public String getBeanDefinitionName() {
        return null;
    }

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getBeanFactory().getBean(name);
        return bean;
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        Object bean = getBeanFactory().getBean(name,args);
        return bean;
    }



    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return null;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];
    }
}
