package crazyBook.C16.C16_6.condition;

public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            account.draw(drawAmount);
        }
    }
}
