package com.wang.springframework.context.support;

import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.BeanFactory;
import com.wang.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.wang.springframework.beans.factory.config.BeanPostProcessor;
import com.wang.springframework.context.ConfigurableApplicationContext;
import com.wang.springframework.core.io.DefaultResourceLoader;

import java.util.Iterator;
import java.util.Map;

/**
 * @author zsw
 * @create 2022-07-30 10:43
 */
public abstract class  AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
 //1.创建 BeanFactory,并加载BeanDefinition
        refreshBeanFactory();
  //2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
   //3.在Bean实例化之前，执行BeanFactoryPostprocessor
        invokeBeanFactoryPostProcessors(beanFactory);
    //4.BeanPostProcessor需要提前于其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessor(beanFactory);
    //5.提前实例化单例对象
    beanFactory.preInstantiateSingletons();
    }
    public abstract void refreshBeanFactory();
    public abstract ConfigurableListableBeanFactory getBeanFactory();
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){

    }

    public abstract String getBeanDefinitionName();
    public abstract Object getBean(String name);
    public abstract Object getBean(String name,Object... args);

    public  void registerBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        Map<String, BeanPostProcessor> beansPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor: beansPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }


    }



}
