package crazyBook.C8.C8_5;

import java.util.PriorityQueue;
/*
* PriorityQueue是一个比较标准的队列实现类.之所以说它是比较标准的队列实现,而不是绝对标准
* 的队列实现,是因为PriorityQueu保存队列元素的顺序并不是按加入队列的顺序,而是按队列元素的
* 大小进行重新排序.
* 因此当调用peek()(获取队列头部的元素,但是不删除此元素.若此队列为空返回则null),
* 或者当调用pool()(获取队列头部的元素,并删除此元素.若此队列为空则返回null)方法
* 取出队列中的元素时,并不是取出最先进入队列的元素,而是取出队列中最小的元素.
*
* 直接使用PriorityQueue的toString()方法输出时,可能不是按从小到大输出,这是受到了
* toString()方法的影响.实际上,当多次调用PriorityQueue集合对象的poll()方法,即可
* 看到元素从小到的的吮吸"移出队列".
*
* PriorityQueue不允许插入null元素,它还需要对队列元素进行排序,PriorityQueue的元素
* 有两种排序方式
* →自然排序
* →定制排序
* ↑使用方法与TreeSet类似
* */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        //下面代码依次向pq中加入四个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        //输出pq队列,并不是按元素的加入顺序排列
        System.out.println(pq);
        //访问队列的第一个元素,其实就是队列中最小的元素
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        /*输出结果
        * [-3, 6, 20, 18]
        *  -3
        *  6
        *  18
        *  20
        * */
    }
}
