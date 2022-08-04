package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.ApplicationContextAware;
import com.wang.springframework.beans.factory.config.BeanPostProcessor;
import com.wang.springframework.context.ApplicationContext;

/**
 * @author zsw
 * @create 2022-08-04 15:45
 */
public  class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
           ( (ApplicationContextAware)bean).setApplicationContextAware(applicationContext);
        }
        return  bean;
    }
    public Object postProcessAfterInitialization(Object bean,String beanName){
       return bean;

    }

}
