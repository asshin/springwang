package com.wang.springframework.beans.factory;

import com.wang.springframework.beans.BeansException;

/**
 * @author zsw
 * @create 2022-07-28 15:10
 */
public interface BeanFactory {
    Object getBean(String BeanName) throws BeansException;
    Object getBean(String BeanName,Object[] args) throws BeansException;
}
