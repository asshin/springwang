package com.wang.springframework.beans.factory;

/**
 * @author zsw
 * @create 2022-08-04 22:14
 */
public interface FactoryBean<T> {
   T  getObject();
    Class<?> getObjectType();
    boolean isSingleton();
}
