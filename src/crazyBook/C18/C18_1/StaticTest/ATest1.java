package crazyBook.C18.C18_1.StaticTest;

public class ATest1 {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();

        a.a++;
        System.out.println(b.a);
    }
}
