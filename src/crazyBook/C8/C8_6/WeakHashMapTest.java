package crazyBook.C8.C8_6;

/*
* WeakHashMap与HashMap的用法基本类似。
* 区别在于
*   WeakHashMap中每个key对象只持有对实际对象的若引用，因此，当垃圾回收了该key所对应
*   的实际对象之后，WeakHashMap会自动删除该key所对应的key-value对
*
*   关键:key的对象引用是否是强引用.
* */

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<String, String> whm = new WeakHashMap<>();
        // 向WeakHashMap中添加三个key-value对
        // 三个key都是匿名字符串对象(没有其他引用)
        whm.put(new String("语文"), new String("良好"));
        whm.put(new String("数学"), new String("及格"));
        whm.put(new String("英语"), new String("中等"));
        //向WeakHashMap中添加一个key-value对
        //该key是一个系统缓存的字符串对象
        whm.put("java", new String("中等"));
        //输出whm对象,将看到4个key-value对
        System.out.println(whm);
        //通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();
        // 在通常情况下,将只看到一个key-value对
        System.out.println(whm);
        /*↓↓↓↓↓↓输出如下↓↓↓↓↓↓↓
        {java=中等, 数学=及格, 英语=中等, 语文=良好}
        {java=中等}*/

        /*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
        *   从上面运行结果可以看出,当系统进行垃圾回收时,删除了WeakHashMap对象的前三个
        * key-value对.这是因为添加前三个key-value对时,这三个key都是匿名的字符串对象,
        * WeakHashMap只保留了对它们的弱引用,这样垃圾回收时会自动删除这三个key-value对
        *   WeakHashMap对象中第4个组key-value对的key时一个字符串直接量,(系统会自动保留
        * 对该字符串对象的强引用),所以垃圾回收时不会回收它.
        * */
    }
}
