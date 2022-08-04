package com.wang.springframework.bean;

/**
 * @author zsw
 * @create 2022-08-04 23:41
 */
public class UserFactoryBean implements com.wang.springframework.beans.factory.FactoryBean {
    @Override
    public Object getObject() {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
