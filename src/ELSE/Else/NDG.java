package ELSE.Else;

import java.util.Scanner;

public class NDG {

    public static int recursion(int n) {
        if (n == 1) return n;
        return n * recursion(n-1);
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.close();

        int mul = recursion(n);

        System.out.println(mul);
    }
}
