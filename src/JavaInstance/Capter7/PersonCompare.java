package JavaInstance.Capter7;

import java.util.Comparator;

public class PersonCompare implements Comparator<Person2> {

    @Override
    public int compare(Person2 o1, Person2 o2) {
        int i = 0;
        i = o1.getName().compareToIgnoreCase(o2.getName());
        if (i == 0) {
            return o1.getAge() - o2.getAge();
        } else {
            return 0;
        }
    }
}
