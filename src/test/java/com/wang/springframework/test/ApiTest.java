package com.wang.springframework.test;

import com.sun.xml.internal.ws.api.server.ServiceDefinition;
import com.wang.springframework.bean.User;
import com.wang.springframework.beans.factory.PropertyValue;
import com.wang.springframework.beans.factory.PropertyValues;
import com.wang.springframework.beans.factory.config.BeanDefinition;
import com.wang.springframework.beans.factory.BeanFactory1;
import com.wang.springframework.bean.UserService;
import com.wang.springframework.beans.factory.config.BeanReference;
import com.wang.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wang.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.wang.springframework.core.io.DefaultResourceLoader;

/**
 * @author zsw
 * @create 2022-07-28 14:28
 */
public class ApiTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        PropertyValue propertyValue =new PropertyValue("user",new BeanReference("user"));
//        PropertyValues propertyValues =new PropertyValues();
//        propertyValues.addPropertyValue(propertyValue);
//        BeanDefinition ServiceDefinition=new BeanDefinition();
//        ServiceDefinition.setaClass(UserService.class);
//        ServiceDefinition.setPropertyValues(propertyValues);
//        BeanDefinition UserDefinition=new BeanDefinition();
//        UserDefinition.setaClass(User.class);
//        defaultListableBeanFactory.RegistryBeanDefinition("service",ServiceDefinition);
//        defaultListableBeanFactory.RegistryBeanDefinition("user",UserDefinition);
//        String [] s={"wang","12"};
//        UserService service = (UserService)defaultListableBeanFactory.getBean("service",s);
//        service.getUser().sayhello();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory, new DefaultResourceLoader());
        xmlBeanDefinitionReader.loadDefinitions("classpath:spring.xml");
        User user = (User)defaultListableBeanFactory.getBean("user");
        user.sayhello();

        UserService userService =(UserService) defaultListableBeanFactory.getBean("userService");
        userService.getUser().sayhello();
        System.out.println(userService.toString());

    }
}
