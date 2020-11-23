package top.faroz.test;

import top.faroz.util.Stack;

/**
 * @ClassName StackTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/23 上午8:21
 * @Version 1.0
 **/
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }
}
