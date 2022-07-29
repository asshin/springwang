package com.wang.springframework.BeanUtil;

import java.lang.reflect.Field;

/**
 * @author zsw
 * @create 2022-07-28 20:23
 */
public class beanUtil {

    public static  void setField(Object bean,String name,Object value) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = bean.getClass().getDeclaredField(name);
        declaredField.setAccessible(true);
        declaredField.set(bean,value);
    }
}
