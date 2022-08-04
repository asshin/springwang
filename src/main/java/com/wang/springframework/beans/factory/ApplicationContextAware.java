package com.wang.springframework.beans.factory;

import com.wang.springframework.context.ApplicationContext;

/**
 * @author zsw
 * @create 2022-08-04 15:38
 */
public interface ApplicationContextAware extends  Aware {
    void setApplicationContextAware(ApplicationContext applicationContextAware);
}
