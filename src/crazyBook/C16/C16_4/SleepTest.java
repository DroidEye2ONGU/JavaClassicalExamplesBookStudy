package crazyBook.C16.C16_4;

import java.time.LocalDateTime;

public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1+"当前时间:" + LocalDateTime.now());
            Thread.sleep(1000);
        }
    }

}
