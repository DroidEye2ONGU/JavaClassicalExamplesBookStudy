package ELSE.Day5.staticExercise;

public class Counter {
    public int count1 = 0;
    public static int count2 = 0;

    public static void main(String[] args) {
        Counter counterA = new Counter();
        Counter counterB = new Counter();
        counterA.count1++;
        counterA.count2++;
        counterB.count1++;
        counterB.count2++;
        //System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2); //2
    }
}
