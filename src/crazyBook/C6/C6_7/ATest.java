package crazyBook.C6.C6_7;

interface A {
    void test();
}


public class ATest {
    public static void main(String[] args) {
        int age = 8;
       /* 如果不加final但对本地变量在初始化后又进行了赋值,编译将报错
        虽然java8对于被匿名内部类或局部内部类访问的局部变量规定可以用
        final修饰也可以不用final修饰,但必须按照有final修饰的方式来用
        也就是一次复制后,以后不能重复赋值*/
        //加上下面这一条代码编译将报错
        //age = 5;
        A a = new A() {
            @Override
            public void test() {
                //在Java 8 以前下面语句将提示错误:age必须使用final修饰
                //从Java 8开始,匿名内部类,局部内部类运行访问非final的局部变量
                System.out.println(age);
            }
        };
        a.test();
    }
}
