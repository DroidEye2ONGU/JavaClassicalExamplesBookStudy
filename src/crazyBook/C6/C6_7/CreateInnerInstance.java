package crazyBook.C6.C6_7;

public class CreateInnerInstance {
    public static void main(String[] args) {
        Out.In in = new Out().new In("测试信息");
        int age = in.age;
        System.out.println(age);
    }
}

class Out {
    //定义一个内部类,不适用访问控制符
    //即只有同一个包中的其他类可以访问该内部类
    class In {
        public int age = 5;
        public In(String msg) {
            System.out.println(msg);
        }
    }


}