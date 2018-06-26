package crazyBook.C16.C16_6.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    // 显式定义Lock对象
    private final Lock lock = new ReentrantLock();
    // 获得指定Lock对象对应的Condition
    private final Condition condition = lock.newCondition();

    private String accountNo;
    private double balance;

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

    public void draw(double drawAmount) {
        // 加锁
        lock.lock();
        try {
            if (!flag) {
                condition.await();
            } else {
                // 执行取钱操作
                System.out.print(Thread.currentThread().getName() +
                        "取钱:" + drawAmount + "\t");
                balance -= drawAmount;
                System.out.println("账户余额为:" + balance);
                // 将标识账户是否已有存款的旗标设为false
                flag = false;
                // 唤醒其他线程
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 使用finally块来释放锁
        finally {
            lock.unlock();
        }

    }

    public void deposit(double depositAmount) {
        lock.lock();
        try {
            if (flag) {
                condition.await();
            } else {
                // 执行存款操作
                System.out.print(Thread.currentThread().getName() +
                        "存款:" + depositAmount + "\t");
                balance += depositAmount;
                System.out.println("账户余额为: " + balance);
                // 将表示账户是否已有存款的旗标设置为true
                flag = true;
                // 唤醒其他线程
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
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

    /*
   synchronized        object  ||        Lock(ReentrantLock)  Condition
隐式同步监视器 this      wait()               显式同步监视器----->await()
                       notify()                                signal()
                      notifyAll()                             signalAll()*/
}
