package crazyBook.C16.C16_5.synchronizedMethod;

public class DrawThread extends Thread{
    // 模拟用户账户
    private Account account;
    // 当前取钱线程所希望取的钱数
    private double drawAmount;
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        /*
        * 直接调用 account对象的draw()方法来执行取钱操作
        * 同步方法的同步监视器是this,this代表调用draw()方法的对象
        * 也就是说,线程进入draw()方法之前,必须先对account对象加锁
        * */
        account.draw(drawAmount);
    }
}
