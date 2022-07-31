package com.wang.springframework.PostProcessor;

import com.wang.springframework.bean.User;
import com.wang.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author zsw
 * @create 2022-07-31 20:07
 */
public class MyPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (beanName.equals("user")){
            System.out.println("my name is zhao shiwang12");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return null;
    }
}
