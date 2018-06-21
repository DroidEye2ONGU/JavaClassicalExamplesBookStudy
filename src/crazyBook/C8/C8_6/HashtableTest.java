package crazyBook.C8.C8_6;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

class A {
    int count;

    public A(int count) {
        this.count = count;
    }

    //根据count的值判断两个对象是否相等
    @Override
    public boolean equals(Object object) {
        if (object== this) return true;
        if (object != null && object.getClass() == A.class) {
            A a = (A) object;
            return this.count == a.count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.count;
    }

    @Override
    public String toString() {
        return "A{" +
                "count=" + count +
                '}';
    }
}

class B {
    //重写equals()方法,B对象与任何对象通过equals()方法比较都返回true
    @Override
    public boolean equals(Object object) {
        return true;
    }

    @Override
    public String toString() {
        return "this is b class' toString method";
    }
}

public class HashtableTest {
    public static void main(String[] args) {
        //Hashtable ht = new Hashtable();
        HashMap ht = new HashMap();
        ht.put(new A(60000), "愣鬼先锋");
        ht.put(new A(87563), "愣鬼放屁");
        ht.put(new A(1232), new B());


        Set<Map.Entry> set = ht.entrySet();
        for (Map.Entry e :
                set) {
            System.out.println(e.getValue());
        }

        System.out.println(ht + "\n\n");

        //只要两个对象通过equals()方法比较返回true
        //Hashtable就认为他认为它们是相等的value
        //由于Hashtable中只有一个B对象
        //它与任何对象通过equals()方法比较都相等,所以下面输出true
        System.out.println(ht.containsValue("测试字符串") + "\n\n");

        // 只要两个A对象的count相等,他们通过equals()方法比较返回true,且hashCode值相等
        //↑↑↑↑↑↑↑↑↑↑↑都是先调用hashCode()比较,相同的话再调用equals()方法比较
        //Hashtable即认为它们是相同的key,所以下面输出true
        System.out.println(ht.containsKey(new A(87563)) + "\n\n");

        //下面语句可以删除最后一个key-value对
        ht.remove(new A(1232));
        System.out.println(ht);
    }
}
