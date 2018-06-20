package ELSE;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IterateList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String s = "aa";

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("aa");
        list.add("dd");
        list.add("ee");
        list.add("ff");
        list.add("aa");
        list.add("gg");
        list.add("hh");

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String t = listIterator.next();
            if (t.equals(s)) {
                listIterator.remove();
                continue;
            }
            System.out.println(t);
        }

    }

}
