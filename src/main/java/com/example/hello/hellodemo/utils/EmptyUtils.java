package com.example.hello.hellodemo.utils;

/**
 * Created by sunyuqing on 2019/9/24.
 */
public class EmptyUtils {
    public static boolean isEmpty(Object o) {
        if (o instanceof String)
            return "".equals(o);
        else if (o instanceof Float)
            return (float)o >= 0;

        return o == null;
    }
}

