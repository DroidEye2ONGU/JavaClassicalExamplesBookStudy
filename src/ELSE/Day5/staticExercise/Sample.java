package ELSE.Day5.staticExercise;

public class Sample {
    static int i = 5;
    static {
        System.out.println("First Static code i="+i++); //5 i = 6
    }
    static {
        System.out.println("Second Static code i="+i++);//6 i = 7
    }
    public static void main(String[] args) {
        Sample s1 = new Sample();
        Sample s2 = new Sample();
        System.out.println("At last, i= "+i); // i = 7
    }
}