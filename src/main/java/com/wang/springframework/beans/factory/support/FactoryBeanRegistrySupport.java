package com.wang.springframework.beans.factory.support;

import com.wang.springframework.beans.factory.FactoryBean;
import com.wang.springframework.exception.BeansException;

import javax.naming.Name;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zsw
 * @create 2022-08-04 22:19
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private ConcurrentHashMap<String,Object> factoryBeanObjectCache =new ConcurrentHashMap<String,Object>();
    protected Object getCachedObjectForFactoryBean(String beanName){
        Object object = this.factoryBeanObjectCache.get(beanName);
        return object!=NULL_OBJECT?object:null;
    }
    protected   Object getObjectFromFactoryBean(FactoryBean factoryBean,String beanName){
        if(factoryBean.isSingleton()){
            Object object = this.factoryBeanObjectCache.get(beanName);

            if (object==null){
                object=doGetObjectFromFactoryBean(factoryBean,beanName);
                this.factoryBeanObjectCache.put(beanName,(object!=null?object:NULL_OBJECT));
            }
            return (object!=null?object:NULL_OBJECT);
        }else {
            return  doGetObjectFromFactoryBean(factoryBean,beanName);
        }

    }

    //对应final修饰的基本数据类型方法内部是不可以变得，但是引用数据类型是引用不可以变，但是值可以变
    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean,final String beanName){
        try {
            return factoryBean.getObject();
        }catch (Exception e){
            throw new BeansException("factory throw exception on object["+beanName+"]creation",e);
        }

    }
}
