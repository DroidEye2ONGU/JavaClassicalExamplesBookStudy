package ELSE.JavaSE.Day16;

public class Student {
    private String id;
    private String name;
    private int age;
    private String city;

    public Student() {
    }

    public Student(String id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 所在城市='" + city + '\'' +
                '}';
    }

    public String toString2() {
        return id + "," + name + "," + age + "," + city;
    }
}