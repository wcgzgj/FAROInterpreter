package top.faroz.util;

import java.util.LinkedList;

/**
 * @ClassName Stack
 * @Description 维护一个LinkedList，实现栈的数据结构
 * @Author FARO_Z
 * @Date 2020/11/16 下午7:56
 * @Version 1.0
 **/
public class Stack<T> {
    private LinkedList<T> list=new LinkedList<>();

    public void push(T elem) {
        list.add(elem);
    }

    public T pop() {
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size()==0;
    }


}
