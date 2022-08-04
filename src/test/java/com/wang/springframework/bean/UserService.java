package com.wang.springframework.bean;


import com.wang.springframework.beans.factory.ApplicationContextAware;
import com.wang.springframework.beans.factory.BeanNameAware;
import com.wang.springframework.context.ApplicationContext;

/**
 * @author zsw
 * @create 2022-07-28 14:29
 */
public class UserService implements BeanNameAware , ApplicationContextAware {
    private  String name;
    private  String age;
    private  User user;
    private String beanName;
    private ApplicationContext applicationContext;

    public UserService(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public UserService() {
    }

    public UserService(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void setBeanNameAware(String beanName) {
        this.beanName=beanName;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationContextAware(ApplicationContext applicationContextAware) {
        this.applicationContext=applicationContextAware;
    }
}
