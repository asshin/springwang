package com.wang.springframework.beans.factory.config;

import com.wang.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author zsw
 * @create 2022-07-30 10:55
 * 可获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口
 * 提供分析和修改Bean以及预先实例化的操作接口，不
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
    String SCOPE_SINGLETON = null;
    String SCOPE_PROTOTYPE = null;
}
