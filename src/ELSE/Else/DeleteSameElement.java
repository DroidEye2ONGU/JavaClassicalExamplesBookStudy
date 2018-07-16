package ELSE.Else;

import java.util.LinkedHashSet;

public class DeleteSameElement {
    public static void main(String[] args) {
        String[] arr = {"a", "a", "c", "d", "h", "h", "1", "0"};

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            linkedHashSet.add(arr[i]);
        }

        linkedHashSet.forEach(s ->
                System.out.println(s));
    }
}
