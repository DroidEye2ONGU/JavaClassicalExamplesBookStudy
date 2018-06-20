package crazyBook.C6.C6_7;

public class Test {
   public  class Inner {
       private static final int age = 5;
        public static final int num = 3;
    }

    public static void innerTest(){
        System.out.println(Inner.age);
        System.out.println(Inner.num);
    }

    public static void main(String[] args) {
        innerTest();
    }
}
