package crazyBook.C16.C16_9;

class Account {
    /*
     *   定义一个ThreadLocal类型的变量,该变量将是一个线程局部变量
     *   每个线程都会保留该变量的一个副本
     * */
    private ThreadLocal<String> name = new ThreadLocal<>();
    // 定义一个初始化name成员变量的构造器

    public Account(String name) {
        this.name.set(name);
        // 下面代码用于访问当前线程的name副本的值
        System.out.println("---" + this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}

class MyTest extends Thread {
    // 定义哦一个Account类型的成员变量
    private Account account;

    public MyTest(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 当 i == 6 时输出将账户名替换成当前线程名
            if (i == 6) {
                account.setName(getName());
            }
            // 输出同一个账户的账户名和循环变量
            System.out.println(account.getName() +
                    " 账户的i值:" + i);
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        // 启动两个线程,两个线程共享同一个Account
        Account at = new Account("初始名");
        /*
        * 虽然两个线程共享同一个账户,即只有一个账户名
        * 但由于账户名时ThreadLocal类型的,所以每个线程
        * 都完全拥有各自账户名的副本,因此在i==6之后,将看到两个
        * 线程访问同一个账户时出现不同的账户名
        * */
        new MyTest("线程甲", at).start();
        new MyTest("线程乙", at).start();
    }
}
