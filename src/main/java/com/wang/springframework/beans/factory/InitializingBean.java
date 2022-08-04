package com.wang.springframework.beans.factory;

/**
 * @author zsw
 * @create 2022-07-31 21:33
 */
public interface InitializingBean {
    Object afterPropertiesSet();
}
