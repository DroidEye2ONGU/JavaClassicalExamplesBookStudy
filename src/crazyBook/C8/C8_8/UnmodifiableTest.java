package crazyBook.C8.C8_8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiableTest {
    public static void main(String[] args) {
        //创建一个空的 不可变的List对象
        List unmodifiableList = Collections.emptyList();

        //创建一个只有一个元素,且不可改变的Set对象
        Set unmodifiableSet = Collections.singleton("疯狂Java讲义");

        //创建一个普通的Map对象
        Map sources = new HashMap();
        sources.put("语文", 80);
        sources.put("Java", 82);

        //返回普通的Map对象对应的不可变版本
        Map unmodifiableMap = Collections.unmodifiableMap(sources);

        //下面的任意一行代码都将引发UnsupportedOperationException异常
        unmodifiableList.add("测试元素");
        unmodifiableSet.add("测试元素");
        unmodifiableMap.put("语文", 90);
    }
}
