package crazyBook.C16.C16_6.condition;

public class DepositThread extends Thread {
    private Account account;
    private double depositAmount;

    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("\n\n" + getName() + i + "\n\n");
            account.deposit(depositAmount);
        }
    }
}

