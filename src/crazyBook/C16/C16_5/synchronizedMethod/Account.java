package crazyBook.C16.C16_5.synchronizedMethod;
/*
*   下面程序中增加了一个代表取钱的draw()方法,并使用synchronized关键字修饰该方法,
* 把该方法变成同步方法,该同步方法的同步监视器是this,因此对于同一个Account账户
* 而言,任意时刻只能有一个线程获得对Account对象的锁定,然后进入draw()方法执行取钱
* 操作--这样也可以保证多个线程并发取钱的线程安全.
*       因为Account类中已经提供了draw()方法,而且取消了setBalance()方法,DrawThread
*   线程类需要改写,该线程类的run方法只调用Account对象的draw()方法即可执行取钱操作.
*
* */
public class Account {
    private String accountNo;
    private double balance;

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
    // 因为账户余额不允许随便修改,所以只为balance提供getter方法
    public double getBalance() {
        return balance;
    }

    //提供一个线程安全的draw()方法来完成取钱操作
    public synchronized void draw(double drawAmount) {
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName() +
                    "取钱成功!吐出钞票:" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= drawAmount;
            System.out.println("\t余额为:" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    "取钱失败!余额不足!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        return accountNo != null ? accountNo.equals(account.accountNo) : account.accountNo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNo != null ? accountNo.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
