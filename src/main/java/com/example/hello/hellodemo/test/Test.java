package com.example.hello.hellodemo.test;

import java.lang.reflect.Field;

/**
 * Created by sunyuqing on 2019/10/15.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Person person = new Person("234545","ddd","44444");
        Field[] fields = person.getClass().getDeclaredFields();
        for(Field field:fields) {
            Range range = field.getAnnotation(Range.class);
            if(range != null) {
                Object o = field.get(person);
                if(o instanceof String) {
                    String s = (String) o;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }

            }
        }
    }
}