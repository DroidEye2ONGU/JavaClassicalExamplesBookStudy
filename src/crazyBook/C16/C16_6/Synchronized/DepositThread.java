package crazyBook.C16.C16_6.Synchronized;

public class DepositThread extends Thread {
    private Account account;
    private double depositAmount;


    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    // 重复100次执行存款操作

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //每次循环不一定都会存进去钱,在100次存钱过程中,
            //如果遇到wait()方法线程阻塞就会结束存钱方法,等待唤醒执行
            //下一次存钱方法
            account.deposit(depositAmount);
        }
    }
}
