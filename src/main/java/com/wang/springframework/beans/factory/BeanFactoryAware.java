package com.wang.springframework.beans.factory;

/**
 * @author zsw
 * @create 2022-08-04 15:38
 */
//实现此接口，既能感知到所属的 BeanFactory
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory);
}
