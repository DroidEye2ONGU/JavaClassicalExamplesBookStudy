package crazyBook.C6.C6_7;

abstract class Device {
    private String name;

    public abstract double getPrice();

    public Device() {

    }

    public Device(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
* CTRL+P   方法参数提示
 * */
public class AnonymousInner {
    public void test(Device d) {
        System.out.println("购买了一个" + d.getName() +
                ",花掉了" + d.getPrice());
    }

    public static void main(String[] args) {
        AnonymousInner ai = new AnonymousInner();
        ai.test(new Device("电子示波器") {
            @Override
            public double getPrice() {
                return 67.8;
            }
        });
        //调用无参数的构造器创建Device匿名实现类的对象
        Device d = new Device() {
            //初始化快
            {
                System.out.println("匿名内部类的的初始化快");
            }
            //实现抽象方法
            @Override
            public double getPrice() {
                return 56.2;
            }
            //重写父类的实现方法

            @Override
            public String getName() {
                return "键盘";
            }
        };
        ai.test(d);
    }
}
