package crazyBook.C15.C15_9;

import java.nio.CharBuffer;

public class BufferTest {
    public static void main(String[] args) {
        //创建Buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity:" + buff.capacity());
        //开始时Buffer的position为0,limit为capacity
        System.out.println("limit:" + buff.limit());
        System.out.println("position" + buff.position());

        //放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入如三个元素后,position = " + buff
                .position());

        //调用flip()方法
        //flip() 该方法将limit设置为position所在位置
        buff.flip();
        System.out.println("执行flip()后, limit = " +
                buff.limit());
        System.out.println("position = " + buff.position());

        //取出第一个元素
        //buff.get()
        //相对:从Buffer的当前position处开始读取或写入数据,然后将位置(position)
        //的值按处理元素的个数增加
        //buff.get(int index)
        //绝对:直接根据索引向Buffer中读取或写入数据,使用绝对方式访问Buffer
        //里的数据时,并不会影响position的值
        System.out.println("第一个元素(position = 0) : " +
                buff.get());
        System.out.println("取出第一个元素后,position = " +
                buff.position());

        //调用clear()方法
        buff.clear();
        System.out.println("执行clear()后, limit = " +
                buff.limit());
        System.out.println("执行clear()后, position = " +
                buff.position());
        System.out.println("执行clear()后,缓冲区内容并没有被清除:" +
                "第三个元素为: " + buff.get(2));
        System.out.println("执行绝对读取后,position = " +
                buff.position());
    }
}
