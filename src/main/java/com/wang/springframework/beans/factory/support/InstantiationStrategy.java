package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author zsw
 * @create 2022-07-28 16:20
 */
public interface InstantiationStrategy {
    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor,Object[] args) throws NoSuchMethodException;
}
//有constructor这个参数的目的就是为了拿到符合入参信息相对应的构造函数。
