package com.wang.springframework.beans.factory.config;

import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.BeanFactory;

/**
 * @author zsw
 * @create 2022-07-30 10:55
 * 是一个自动化处理Bean工厂配置的接口，
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName);
}
