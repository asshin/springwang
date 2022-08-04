package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.BeanFactory;
import com.wang.springframework.beans.factory.config.BeanDefinition;
import com.wang.springframework.beans.factory.config.BeanPostProcessor;
import com.wang.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.wang.springframework.beans.factory.support.DefaultSingletonBeanRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsw
 * @create 2022-07-28 15:11
 */
public abstract  class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public Object getBean(String BeanName) throws BeansException {
       Object bean=getSingleton(BeanName);
       if (bean!=null){
           return  bean;
       }
       /* 此处定义getbean模板方法，getBeanDefinition和creatBean方法的
       具体实现由子类实现，这是模板方法设计模式的一个实现
       * */
        BeanDefinition beanDefinition=getBeanDefinition(BeanName);
        bean=creatBean(BeanName,beanDefinition,null);
        return bean;
    }
    public Object getBean(String BeanName,Object[] args) throws BeansException {
        Object bean=getSingleton(BeanName);
        if (bean!=null){
            return  bean;
        }
       /* 此处定义getbean模板方法，getBeanDefinition和creatBean方法的
       具体实现由子类实现，这是模板方法设计模式的一个实现
       * */
        BeanDefinition beanDefinition=getBeanDefinition(BeanName);
        bean=creatBean(BeanName,beanDefinition,args);
        return bean;
    }
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }
    public abstract BeanDefinition getBeanDefinition(String name);
    public abstract Object creatBean(String name,BeanDefinition beanDefinition,Object[] args) throws BeansException;
}
