package crazyBook.C8.C8_6;

import java.util.HashMap;

/*
* HashMap可以使用null作为key或value
*
* 由于HashMap里的key不能重复,所以HashMap里最多只有一个key-value对的key为null,但可以
* 有无数多个key-value对的value为null
* */

public class NullInHashMap {
    public static void main(String[] args) {
        HashMap hm = new HashMap();

        //试图将两个key为null值的key-value对放入HashMap中
        hm.put(null, null);
        hm.put(null, null);
        //讲一个value为null值的key-value对放入HashMap中
        hm.put("a", null);
        //输出Map对象
        System.out.println(hm);
    }
}
