package crazyBook.C8.C8_6;

import java.util.EnumMap;

enum Season {
    SPRING,SUMMER,FALL,WINTER
}

public class EnumMapTest {
    public static void main(String[] args) {
        // 创建EnumMap对象,该EnumMap对象所有key都是Season枚举类的枚举值
        EnumMap enumMap = new EnumMap(Season.class);
        enumMap.put(Season.SUMMER, "夏天");
        enumMap.put(Season.SPRING, "春天");

        System.out.println(enumMap);
        //输出:{SPRING=春天, SUMMER=夏天}
        /*
        * 上面程序中创建了一个EnumMap对象,创建该EnumMap对象时指定它的key只能是Season
        * 枚举类的枚举值.
        * 如果向该EnumMap中添加两个key-value对后,这两个key-value对将会以Season枚举值
        * 的自然顺序排序.
        * */
    }
}
