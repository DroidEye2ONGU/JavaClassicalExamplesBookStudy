package ELSE;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

        list.remove(15);

        list.forEach(s ->
                System.out.println(s));

    }
}
