package com.wang.springframework.context;

import com.wang.springframework.beans.BeansException;

/**
 * @author zsw
 * @create 2022-07-30 10:42
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    void refresh() throws BeansException;
    void registerShutdownHook();
    void close();
}
