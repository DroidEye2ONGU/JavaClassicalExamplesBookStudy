package crazyBook.C16.C16_5.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    // 定义锁对象 ReentrantLock 可重入锁,使用该lock对象可以显式的加锁 释放锁
    private final ReentrantLock lock = new ReentrantLock();

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

    public double getBalance() {
        return balance;
    }

    //  提供一个线程安全的draw()方法来完成取钱操作
    public void draw(double drawAmount) {
        // 加锁
        lock.lock();
        try {
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
        } finally {
            // 修改完成,释放锁
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (lock != null ? !lock.equals(account.lock) : account.lock != null) return false;
        return accountNo != null ? accountNo.equals(account.accountNo) : account.accountNo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = lock != null ? lock.hashCode() : 0;
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
