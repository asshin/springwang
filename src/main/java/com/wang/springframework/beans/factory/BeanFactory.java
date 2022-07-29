package com.wang.springframework.beans.factory;

/**
 * @author zsw
 * @create 2022-07-28 15:10
 */
public interface BeanFactory {
    Object getBean(String BeanName);
    Object getBean(String BeanName,Object[] args);
}
