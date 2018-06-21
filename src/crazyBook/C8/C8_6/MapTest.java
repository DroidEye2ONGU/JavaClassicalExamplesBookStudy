package crazyBook.C8.C8_6;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //成功放入多个 key-value对
        map.put("愣鬼先锋", 120);
        map.put("愣鬼说闲话", 220);
        map.put("愣鬼屁股", 320);
        //多次放入的 key-value 对中的value可以重复
        map.put("愣鬼没脑子",120);
        //放入重复的 key 时,新的value会覆盖原有的value,并返回被覆盖的value
        System.out.println(map.put("愣鬼先锋", 100));

        //判断是否包含指定key
        System.out.println("是否包含值为 '愣鬼屁股' 的key:" +
                map.containsKey("愣鬼屁股"));
        //获取 Map 集合的所有key组成的集合,通过遍历key来实现遍历所有的key-value对
        for (String key :
                map.keySet()) {
            // map.get(key)方法获取指定key对应的value
            System.out.println(key + "--->" + map.get(key));
        }
        //根据key来删除key-value对
        map.remove("愣鬼说闲话");
        System.out.println(map);
    }
}
