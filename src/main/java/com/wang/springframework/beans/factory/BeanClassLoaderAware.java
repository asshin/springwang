package com.wang.springframework.beans.factory;

/**
 * @author zsw
 * @create 2022-08-04 15:36
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
