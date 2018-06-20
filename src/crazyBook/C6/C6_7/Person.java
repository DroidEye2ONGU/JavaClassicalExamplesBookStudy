package crazyBook.C6.C6_7;

import java.time.Period;

public class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Person) {
            o = (Person) o;
            if ((this.getName().equals(((Person) o).getName() )&&
                    (this.getAge() == ((Person) o).getAge()))) {
                return true;
            } else return false;
        } else return false;
    }
}
