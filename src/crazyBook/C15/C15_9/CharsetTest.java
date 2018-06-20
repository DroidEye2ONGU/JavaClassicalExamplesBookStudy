package crazyBook.C15.C15_9;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {
    public static void main(String[] args) {
        //获取Java支持的全部字符集
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        for (String alias :
                stringCharsetSortedMap.keySet()) {
            //输出字符集的别名和对应的Charset对象
            System.out.println(alias + "------->" +
                    stringCharsetSortedMap.get(alias));
        }
        System.out.println("--------------------");
        System.out.println(System.getProperty("file.encoding"));

    }
}
