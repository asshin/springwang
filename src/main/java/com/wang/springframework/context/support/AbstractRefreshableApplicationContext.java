package com.wang.springframework.context.support;

import com.wang.springframework.beans.factory.BeanFactory;
import com.wang.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.wang.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author zsw
 * @create 2022-07-30 11:23
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    DefaultListableBeanFactory beanFactory ;
    protected  abstract  void  loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    public void refreshBeanFactory() {
        DefaultListableBeanFactory beanFactory=createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory=beanFactory;
    }
    public  DefaultListableBeanFactory createBeanFactory(){
        return  new DefaultListableBeanFactory();
    }
    public ConfigurableListableBeanFactory getBeanFactory(){
        return beanFactory;
    }
}
