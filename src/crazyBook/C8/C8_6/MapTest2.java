package crazyBook.C8.C8_6;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //成功放入多个 key-value对
        map.put("愣鬼先锋", 120);
        map.put("愣鬼说闲话", 220);
        map.put("愣鬼屁股", 320);

        //尝试替换 key 为 愣鬼说瞎话的value,由于原Map中没有对应的key,
        //因此Map没有改变,不会添加新的key-value对
        map.replace("愣鬼说瞎话", 100);
        System.out.println(map + "\n\n");

        //使用原Value与传入参数计算出来的结果覆盖原有的value
        map.merge("愣鬼说闲话", 10,
                (oldVal, param) -> (Integer) oldVal + (Integer) param);
        System.out.println(map+"\n\n");//"愣鬼说闲话的value增大了10"

        //当key为"愣鬼"对应value为null(或不存在)时,使用计算的结果作为新value
        map.computeIfAbsent("愣鬼",
                key -> ((String) key).length());
        System.out.println(map + "\n\n");

        //当key为"愣鬼"对应的value存在时,使用计算的结果作为新value
        map.computeIfPresent("愣鬼",
                (key, value) -> (Integer) value * (Integer) value);
        System.out.println(map);
    }
}
