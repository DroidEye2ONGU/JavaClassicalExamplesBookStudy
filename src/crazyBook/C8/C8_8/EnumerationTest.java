package crazyBook.C8.C8_8;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/*
* Enumeration接口是Iterator迭代器的"古老版本",从JDK 1.0开始,Enumeration接口就已经
* 存在了(Iterator从JDK 1.2 才出现).Enumeration 接口只有两个名字很长的方法
* **boolean hasMoreElements()
* **Object nextElement()
*
* Enumeration接口可用于遍历Vector Stack Hashtable BitSet等古老的集合类,(通过调用集合的elements()方法获得Enumeration迭代器)
* 对于ArrayList,HashMap等集合类,不再支持使用Enumeration迭代器
* */
public class EnumerationTest {

    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("老王说事");
        v.add("黄永琪放屁");

        Hashtable sources = new Hashtable();
        sources.put("语文", 78);
        sources.put("数学", 88);

        Enumeration em = v.elements();
        while (em.hasMoreElements()) {
            System.out.println(em.nextElement());
        }

        Enumeration keyEm = sources.keys();
        while (keyEm.hasMoreElements()) {
            Object key = keyEm.nextElement();
            System.out.println(key + "------->" + sources.get(key));
        }
    }
}
