package crazyBook.C6.C6_7;

public class CreateStaticInnerInstance {
    public static void main(String[] args) {
        //外部类以外的类建立静态内部类的对象
        StaticOut.StaticIn in =
                new StaticOut.StaticIn();
    }
}

class StaticOut {
    static class StaticIn {
        public StaticIn() {
            System.out.println("静态内部类构造器");
        }
    }
}