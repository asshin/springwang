package com.wang.springframework.beans.factory.support;

import com.wang.springframework.BeanUtil.beanUtil;
import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.*;
import com.wang.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.wang.springframework.beans.factory.config.BeanDefinition;
import com.wang.springframework.beans.factory.config.BeanPostProcessor;
import com.wang.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @author zsw
 * @create 2022-07-28 15:30
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    private  simpleInstantiationStragegy simpleInstantiationStragegy=new simpleInstantiationStragegy();
    public  Object creatBean(String name, BeanDefinition beanDefinition,Object[] args) throws BeansException {
             Object createBeanInstance = createbeaninstance(name, beanDefinition, args);
             applyPropertyValues(name,beanDefinition,createBeanInstance);
        Object bean = initializedBean(name, createBeanInstance, beanDefinition);
        if (beanDefinition.isSingleton()){
            addSingleton(name, bean);
        }

        return bean;

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
        if (beanDefinition.isSingleton()){
            addSingleton(name,instance);
        }

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
            } catch (BeansException e) {
                e.printStackTrace();
            }


        }

    public simpleInstantiationStragegy getSimpleInstantiationStragegy() {
        return simpleInstantiationStragegy;
    }

    public void setSimpleInstantiationStragegy(simpleInstantiationStragegy simpleInstantiationStragegy) {
        this.simpleInstantiationStragegy = simpleInstantiationStragegy;
    }

    public Object initializedBean(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        //invokeAwareMethods
        if(bean instanceof Aware){
            if(bean instanceof BeanFactoryAware){
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if(bean instanceof BeanClassLoaderAware){
                ((BeanClassLoaderAware) bean).setBeanClassLoader(Thread.currentThread().getContextClassLoader());
            }
            if(bean instanceof  BeanNameAware){
                ((BeanNameAware) bean).setBeanNameAware(beanName);
            }
        }

        //1.执行BeanPostProcessor Before处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
     //待完成任务：invokeInitMethod(beanName,wrappedBean,beanDefinition),初始化
        invokeInitMethods(beanName,wrappedBean,beanDefinition);
     //2.执行BeanPostProcessorsAfter
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }


   public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
       Object result=existingBean;
       List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
       for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
           Object cur = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
           if(cur==null)return result;
           result=cur;//满足条件的beanPostProcessor会改变result的值，其他的不改变。

       }

       return result;
    }
    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }
    protected abstract void registerDisposableBeanIfNecessary();


    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName){
        Object result=existingBean;
        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            Object cur = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if(cur==null)return result;
            result=cur;//满足条件的beanPostProcessor会改变result的值，其他的不改变。

        }
        return result;
    }



}
