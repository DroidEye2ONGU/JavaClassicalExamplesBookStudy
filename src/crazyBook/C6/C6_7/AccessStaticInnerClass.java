package crazyBook.C6.C6_7;
/*
* 对于非静态内部类
* 内部类中的私有属性和方法只能在外部类中新建对象访问
*
*
* */
public class AccessStaticInnerClass {
    static class StaticInnerClass {
        private static int prop1 = 5;
        private int prop2 = 9;

    }

    private class PrivateInnerClass {
        public int age = 5;
    }

    public class PublicInnerClass {
        public int age = 5;

        void printAge() {
            System.out.println(this.age);
        }
    }

    public static void accessInnerProp() {
        //System.out.println(prop1);
        //上面代码出现错误,应改为如下形式
        //通过类名访问静态内部类的成员
        System.out.println(StaticInnerClass.prop1);

        //System.out.println(prop2);
        // 上面代码出现错误,应改为如下形式
        //通过实例访问静态内部类的实例成员
        System.out.println(new StaticInnerClass().prop2);
    }

}

class OutClass {
    public static void main(String[] args) {
        AccessStaticInnerClass.PublicInnerClass publicInnerClass = new AccessStaticInnerClass().new PublicInnerClass();
        publicInnerClass.printAge();
    }
}