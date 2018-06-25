package crazyBook.C8.C8_5;

public class PriorityTest extends Thread {
    // 定义一个有参数的构造器\用于创建线程时指定name
    public PriorityTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + ",其优先级是:" +
                    getPriority() + ",循环变量的值为:" + i);
        }
    }

    public static void main(String[] args) {
        //改变主线程的优先级
        Thread.currentThread().setPriority(6);

        for (int i = 0; i < 30; i++) {
            if (i == 10) {
                PriorityTest low = new PriorityTest("低级");
                low.start();
                //子线程的优先级与创建他的父线程拥有相同的优先级
                System.out.println("创建之初的优先级" + low.getPriority());
            }
            if (i == 20) {
                PriorityTest high = new PriorityTest("高级");
                high.start();
                System.out.println("创建之初的优先级" + high.getPriority());
                //优先级高的线程获得更多的执行机会
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
