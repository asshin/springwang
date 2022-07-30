package com.wang.springframework.beans.factory;

/**
 * @author zsw
 * @create 2022-07-30 10:54
 * 是一个扩展 Bean 工厂接口的接口，新增加了 getBeansOfType、getBeanDefinitionNames() 方法，在 Spring 源码中还有其他扩展方法
 */
public interface ListableBeanFactory<T>  {
   Object getBeanOfType(Class<T> type);
   String getBeanDefinitionName();
}
