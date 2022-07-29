package com.wang.springframework.beans.factory.config;

/**
 * @author zsw
 * @create 2022-07-28 19:57
 */
public class BeanReference {
    String BeanName;

    public BeanReference(String beanName) {
        BeanName = beanName;
    }

    public String getBeanName() {
        return BeanName;
    }


}
