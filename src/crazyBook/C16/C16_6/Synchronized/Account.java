package crazyBook.C16.C16_6.Synchronized;

public class Account {
    private String accountNo;
    private double balance;

    // 标识账户中是否已有存款的旗标
    private boolean flag = false;

    public Account() {

    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            // 如果flag为假,表明账户中还没有人存钱进去,取钱方法阻塞
            if (!flag) {
                // wait():导致当前线程等待,直到其他线程调用该同步监视器的
                // notify()方法或nofifyAll()方法来唤醒该线程.
                // 无参数的wait():一直等待,直到其他线程通知
                // 带毫秒或微毫秒的wait():等待指定时间后自动苏醒
                wait();
            } else {
                // 执行取钱操作
                System.out.print(Thread.currentThread().getName() +
                        "取钱:" + drawAmount + "\t");
                balance -= drawAmount;
                System.out.println("账户余额为:" + balance);
                // 将标识账户是否已有存款的旗标设为false
                flag = false;
                // 唤醒其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            // 如果flag为真,表明账户已经有人存钱进去,存钱方法阻塞
            if (flag) {
                wait();
            } else {
                // 执行存款操作
                System.out.print(Thread.currentThread().getName() +
                        "存款:" + depositAmount + "\t");
                balance += depositAmount;
                System.out.println("账户余额为: " + balance);
                // 将表示账户是否已有存款的旗标设置为true
                flag = true;
                // 唤醒其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (flag != account.flag) return false;
        return accountNo != null ? accountNo.equals(account.accountNo) : account.accountNo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNo != null ? accountNo.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (flag ? 1 : 0);
        return result;
    }
}
