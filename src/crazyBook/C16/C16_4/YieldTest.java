package crazyBook.C16.C16_4;

public class YieldTest extends Thread {
    public YieldTest(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
            // 当i==20时,使用yield()方法让当前线程让步
            if (i == 20) {
                System.out.println(getName() + "-----------");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        //启动两个并发进程
        YieldTest yt1 = new YieldTest("高级");
        //将yt1线程设置成最高优先级
        yt1.setPriority(Thread.MAX_PRIORITY);
        yt1.start();



        YieldTest yt2 = new YieldTest("低级");
        yt2.setPriority(Thread.MIN_PRIORITY);
        yt2.start();
    }
}
