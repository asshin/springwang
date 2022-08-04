package com.wang.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import com.wang.springframework.beans.BeansException;
import com.wang.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.wang.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zsw
 * @create 2022-07-28 15:32
 */
public class DefaultListableBeanFactory extends  AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry , ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void RegistryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }



    @Override
    public  <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getaClass();
            if (type.isAssignableFrom(beanClass)) {
                try {
                    result.put(beanName, (T) getBean(beanName));
                } catch (BeansException e) {
                    e.printStackTrace();
                }
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeanException("beandefinition is null");
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons()  {
//        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    protected void registerDisposableBeanIfNecessary() {

    }

    @Override
    public void destroySingletons() {

    }
}
