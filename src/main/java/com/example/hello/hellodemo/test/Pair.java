package com.example.hello.hellodemo.test;

/**
 * Created by sunyuqing on 2019/11/5.
 */
public class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public static void main(String[] args) {
        Pair<String> pair = new Pair<>("one","two");
        Pair<String> p1 = new Pair<>("Hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();

        System.out.println(pair.getFirst()+pair.getLast());
    }
}
