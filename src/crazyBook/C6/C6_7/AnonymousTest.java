package crazyBook.C6.C6_7;
/*
* 匿名内部类适合创建那种只需一次使用的类
*创建匿名内部类时会立即创建一个类的实例,
* 这个类定义立即消失,匿名内部类不能重复使用
* */
public class AnonymousTest {
    public void test(Prodect p) {
        System.out.println("购买了一个" + p.getName() +
                ",花掉了" + p.getPrice());
    }

    public static void main(String[] args) {
        AnonymousTest ta = new AnonymousTest();
        //调用test()方法时,需要传入一个Product参数
        //此处传入其匿名内部类的实例
        ta.test(new Prodect() {
            /*匿名内部类中不能定义构造器,但是可以通过定义
            * 初始化块来完成无须接收参数的初始化工作*/
            {
                System.out.println("匿名内部类中的初始化块");
            }
            @Override
            public double getPrice() {
                return 567.8;
            }

            @Override
            public String getName() {
                return "GTX1080Ti";
            }
        });
    }
}
//p210
interface Prodect {
    public double getPrice();
    public String getName();
}
