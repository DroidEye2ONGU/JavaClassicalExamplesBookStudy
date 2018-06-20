package crazyBook.C6.C6_7;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> newList = new ArrayList<>();

        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");

        for (String a :
                list) {
            if (!newList.contains(a)) newList.add(a);
        }

        for (String t :
                newList) {
            System.out.println(t);
        }
    }
}
