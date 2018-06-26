package crazyBook.C16.C16_6.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        // 定义一个长度为2的阻塞队列
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        bq.put("java"); //与bq.add("java") bq.offer("java")相同
        bq.put("java");
        bq.put("java"); // 阻塞线程

        // 当队列满的时候,使用put()会阻塞线程,使用add()会引发异常,使用offer()会返回false
    }
}
