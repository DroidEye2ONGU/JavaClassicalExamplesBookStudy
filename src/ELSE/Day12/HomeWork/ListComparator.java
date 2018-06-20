package ELSE.Day12.HomeWork;

import java.util.Comparator;

public class ListComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.equals(o2)) return 0;
        return o1.compareTo(o2);

    }
}
