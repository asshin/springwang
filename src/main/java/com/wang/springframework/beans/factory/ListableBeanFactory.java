package com.wang.springframework.beans.factory;

import com.wang.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author zsw
 * @create 2022-07-30 10:54
 * 是一个扩展 Bean 工厂接口的接口，新增加了 getBeansOfType、getBeanDefinitionNames() 方法，在 Spring 源码中还有其他扩展方法
 */
public interface ListableBeanFactory{

   <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
   /**
    * Return the names of all beans defined in this registry.
    *
    * 返回注册表中所有的Bean名称
    */
   String[] getBeanDefinitionNames();
}

