package com.wang.springframework.beans.factory.config;

import com.wang.springframework.beans.factory.PropertyValues;

/**
 * @author zsw
 * @create 2022-07-28 14:26
 */
public class BeanDefinition<T> {
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;
    Class<T> aClass;
    String initMethodName;
    String destroyMethodName;
    PropertyValues propertyValues;
    private String scope = SCOPE_SINGLETON;

    private boolean singleton = true;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
        singleton=(scope.equals(SCOPE_SINGLETON));
        prototype=(scope.equals(SCOPE_PROTOTYPE));

    }
    public boolean isSingleton() {
       return singleton;
    }


    private boolean prototype = false;
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
