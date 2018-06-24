package crazyBook.C16.C16_4;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class DaemonThread extends Thread{
    //定义后台线程的线程执行体与普通线程没有任何区别
    public void run() {
            for (int i = 0;; i++) {
                System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread();
        //将此线程设置为后台线程
        t.setDaemon(true);
        //启动后台线程
        t.start();


        int a = new Scanner(System.in).nextInt();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        t.isAlive();
    }
}
