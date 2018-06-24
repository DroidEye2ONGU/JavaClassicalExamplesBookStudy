package crazyBook.C16.C16_4;

public class JoinThread extends Thread{
    // 提供一个有参数的构造器,用于设置线程的名字
    public JoinThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        //启动子线程
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被Join的线程");
                jt.start();

                // main线程调用了it线程的join()方法,main线程
                // 必须等jt结束了才会向下执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() +
                    " " + i);
        }
    }
}
