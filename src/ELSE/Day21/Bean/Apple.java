package ELSE.Day21.Bean;

public class Apple implements Fruit {
    public Apple() {
        System.out.println("Apple's Constructor...");
    }

    @Override
    public void squeeze() {
        System.out.println("榨一杯苹果汁");
    }


}
