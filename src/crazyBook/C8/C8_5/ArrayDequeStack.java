package crazyBook.C8.C8_5;

import java.util.ArrayDeque;

public class ArrayDequeStack {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        //依次将三个元素push如"栈"
        stack.push("愣鬼先锋");
        stack.push("竹林听雨");
        stack.push("小船过河");

        System.out.println(stack);

        //访问第一个元素,但并不将其pop出栈
        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
