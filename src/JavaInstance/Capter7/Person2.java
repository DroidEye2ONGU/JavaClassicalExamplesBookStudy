package JavaInstance.Capter7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Person2 {

    private String name;
    private int age;

    public Person2() {
    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person2 person1 = new Person2("Mike", 17);
        Person2 person2 = new Person2("Tom", 14);
        Person2 person3 = new Person2("Darwin", 25);
        Person2 person4 = new Person2("Darwin", 16);

        List<Person2> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        //Collections.sort(persons, new PersonCompare());
        Collections.sort(persons, new Person2CompareName());
        Collections.sort(persons, new Person2CompareAge());
        persons.forEach(s -> System.out.println(s));
    }
}
