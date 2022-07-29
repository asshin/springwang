package com.wang.springframework.beans.factory.config;

import com.wang.springframework.beans.factory.PropertyValues;

/**
 * @author zsw
 * @create 2022-07-28 14:26
 */
public class BeanDefinition<T> {
    Class<T> aClass;
    PropertyValues propertyValues;

    public BeanDefinition(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class<T> aClass) {
        this.aClass = aClass;
    }

    public BeanDefinition(Class<T> aClass, PropertyValues propertyValues) {
        this.aClass = aClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public BeanDefinition() {
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Class<T> getaClass() {
        return aClass;
    }

    public void setaClass(Class<T> aClass) {
        this.aClass = aClass;
    }
}
