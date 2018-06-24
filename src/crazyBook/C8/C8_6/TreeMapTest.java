package crazyBook.C8.C8_6;

import java.util.TreeMap;
/*
* 如果使用自定义类作为TreeMap的Key,且想让TreeMap良好的工作，则重写该类的equals()
* 方法和compareTo()方法时应保持一致的返回结果：两个key通过equals()方法比较返回
* true时，它们通过compareTo方法比较应该返回0.如果equals()方法与compareTo()方法
* 的返回结果不一致，TreeMap与Map接口的规则就会冲突。
* */
class R implements Comparable {
    int count;

    public R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R[count:" + count + "]";
    }

    //根据count来判断两个对象是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj.getClass() == R.class) {
            R r = (R)obj;
            return r.count == this.count;
        }
        return false;
    }


    @Override
    public int compareTo(Object o) {
        R r = (R)o;
        return count > r.count ? 1 :
                count < r.count ? -1 : 0;
    }
}

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(new R(3), "轻量级Java EE企业应用实战");
        tm.put(new R(-5), "疯狂Java讲义");
        tm.put(new R(9), "疯狂Android讲义");
        System.out.println(tm);

        //返回该TreeMap的第一个Entry对象
        System.out.println(tm.firstEntry());
        //返回该TreeMap的最后一个key值
        System.out.println(tm.lastKey());
        //返回该TreeMap的比new R(2)大的最小key值
        System.out.println(tm.higherKey(new R(2)));
        //返回该TreeMap的比new R(2)小的最大key-value对
        System.out.println(tm.lowerEntry(new R(2)));
        //返回该TreeMap的子TreeMap
        System.out.println(tm.subMap(new R(-1), new R(4)));
    }

}
