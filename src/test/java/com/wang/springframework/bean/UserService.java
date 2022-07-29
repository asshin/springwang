package com.wang.springframework.bean;

/**
 * @author zsw
 * @create 2022-07-28 14:29
 */
public class UserService {
    private  String name;
    private  String age;
    private  User user;

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
}
