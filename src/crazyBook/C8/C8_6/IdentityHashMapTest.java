package crazyBook.C8.C8_6;

/*
* 用法与HashMap类似,不同在于,在判断key是否相等时,HashMap在判断hashCode()相同和
* equals()方法返回true时认为两个key相等.
* 而IdentityHashMap则当且仅当两个key严格相等(key1 == key2)时,IdentityHashMapTest
* 才认为两个key值相等.
* */

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap ihm = new IdentityHashMap();

        //下面两行代码将会向IdentityHashMap对象中添加两个key-value对
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 78);

        //下面两行代码只会向IdentityHashMap对象中添加一个key-value对
        ihm.put("java", 97);
        ihm.put("java", 98);

        System.out.println(ihm);

        //输出 {语文=78, 语文=89, java=98}
        /*
        * 上面程序试图向IdentityHashMap对象中添加4个key-value对,前2个key-value对
        * 中的key是新创建的字符串对象,它们通过==比较不相等,所以IdentityHashMap会把
        * 它们当成2个key来处理;后2个key-value对中的key都是字符串直接量,而且它们的字
        * 符串序列完全相同,Java使用常量池来管理字符串直接量,所以它们通过==比较返回true,
        * IdentityHashMap会认为它们是同一个key,因此一次可以添加成功.
        * */
    }
}
