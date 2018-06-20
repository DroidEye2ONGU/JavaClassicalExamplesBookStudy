package ELSE;

import java.util.HashSet;
import java.util.Set;

public class PersonTest {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add(new Person("ab", 20));
        set.add(new Person("ba", 20));
        set.add(new Person("ab", 21));
        set.add(new Person("ab", 20));

        for (Object p :
                set) {
            System.out.println((Person)p);
        }
    }
}
