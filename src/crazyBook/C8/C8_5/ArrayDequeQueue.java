package crazyBook.C8.C8_5;

import java.util.ArrayDeque;

public class ArrayDequeQueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
       //依次将三个元素加入队列
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);

        //访问头部的元素,但并不将其poll出队列"栈"
        System.out.println(queue.peek());
        System.out.println(queue);

        //poll出第一个元素
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
