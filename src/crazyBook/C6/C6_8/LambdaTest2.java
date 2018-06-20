package crazyBook.C6.C6_8;

import java.util.ArrayList;
import java.util.List;

interface Fly {
    public void fly(int a);
}

public class LambdaTest2 {
    public static void main(String[] args) {
        int s = 1;
        Fly fly = a -> System.out.println(a);
        fly.fly(s);
    }
}
