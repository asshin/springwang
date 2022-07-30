package com.wang.springframework.beans.factory.support;

import com.wang.springframework.BeanUtil.beanUtil;
import com.wang.springframework.beans.factory.PropertyValue;
import com.wang.springframework.beans.factory.PropertyValues;
import com.wang.springframework.beans.factory.config.BeanDefinition;
import com.wang.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author zsw
 * @create 2022-07-28 15:30
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private  simpleInstantiationStragegy simpleInstantiationStragegy=new simpleInstantiationStragegy();
    public  Object creatBean(String name, BeanDefinition beanDefinition,Object[] args){
        Object createBeanInstance = createbeaninstance(name, beanDefinition, args);
           applyPropertyValues(name,beanDefinition,createBeanInstance);
        return createBeanInstance;

    }

    private Object createbeaninstance(String name, BeanDefinition beanDefinition, Object[] args) {
        Object instance =null;
        Constructor constructor=null;
        Constructor[] declaredConstructors = beanDefinition.getaClass().getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            if(args!=null&&declaredConstructor.getParameterTypes().length==args.length){
                constructor=declaredConstructor;
            }
        }
        try {
            instance=simpleInstantiationStragegy.instantiate(name,beanDefinition,constructor,args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        addSingleton(name,instance);
        return instance;
    }
        public void applyPropertyValues(String beanName,BeanDefinition beanDefinition,Object bean)  {
            try {
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                if (propertyValues!=null){
                    PropertyValue[] propertyValues1 = propertyValues.getPropertyValues();
                    for (PropertyValue propertyValue : propertyValues1) {
                        String name = propertyValue.getName();
                        Object value = propertyValue.getValue();
                        if(value instanceof  BeanReference){
                            BeanReference beanReference= (BeanReference)value;

                            value=getBean(beanReference.getBeanName());

                        }
                        beanUtil.setField(bean,name,value);
                    }
                }

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }

}
