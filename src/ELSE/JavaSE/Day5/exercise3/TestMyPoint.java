package ELSE.JavaSE.Day5.exercise3;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint start = new MyPoint();
        MyPoint end = new MyPoint();

        start.x = 10;
        start.y = 10;

        end.x = 20;
        end.y = 30;

        printPoint(start, "Start");

        MyPoint stray = end;
        printPoint(end, "End");

        printPoint(stray, "Stray");

        stray.x = 50;
        stray.y = 100;
        printPoint(start, "Start");
        printPoint(end, "End");
        printPoint(stray, "Stray");


    }

    public static void printPoint(MyPoint myPoint, String name) {
        System.out.println(name + " point is :" + myPoint);
    }
}
