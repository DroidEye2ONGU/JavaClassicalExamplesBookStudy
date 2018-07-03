package ELSE.Day18.Thread;

/*
 * 线程的join方法,可以让线程插队,优先执行插队的线程t,t执行完成后,再执行本线程
 * */
public class Tesst_07Join {

    public static void main(String[] args) {

        //创建两个子线程th1,th2,th1线程处理函数执行的过程中,让th2插队进来
        // th2插队成功后会优先执行,全部执行完成后,th1再转入运行

        Thread th1 = new Thread("插队线程1") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    System.out.println(getName() + "..." + i);
                }
            }
        };

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i == 50) {
                        try {
                            // 让th1线程插队进来,优先执行
                            th1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName() + "..." + i);
                }
            }
        }, "线程2");

        th1.start();
        th2.start();
    }
}
