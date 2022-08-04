package com.wang.springframework.beans.factory.config;

/**
 * @author zsw
 * @create 2022-07-31 21:41
 */
public class DefaultSingletonBeanFactory implements  ConfigurableBeanFactory {
    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

    }

    @Override
    public void destroySingletons() {

    }

    @Override
    public Object getBean(String BeanName) {
        return null;
    }

    @Override
    public Object getBean(String BeanName, Object[] args) {
        return null;
    }

    @Override
    public Object getSingleton(String BeanName) {
        return null;
    }
}
