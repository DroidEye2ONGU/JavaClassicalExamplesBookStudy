package JavaInstance.Capter7;

import java.util.Comparator;

public class Person2CompareName implements Comparator<Person2> {

    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

}
