package ELSE.Day12;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

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
    public int compareTo(Person o) {
        if (this.name.length() == o.name.length()) {
            if (this.name.equals(o.name)) {
                return this.age - o.age;
            } else {
                return name.compareTo(o.name);
            }
        } else {
            return this.name.length() - o.name.length();
        }
    }
}
