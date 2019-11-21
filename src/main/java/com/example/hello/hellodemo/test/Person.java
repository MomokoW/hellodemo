package com.example.hello.hellodemo.test;

/**
 * Created by sunyuqing on 2019/10/16.
 */
@Report
public class Person {
    @Range(min=1, max=3)
    String name;
    String sex;
    @Range(max=3)
    String age;

    public Person(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
