package ELSE.Day4;

import java.util.Arrays;

public class ArrayClass {
    public static void main(String[] args) {
        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.print("array1中的数：");
        for (int t :
                array1) {
            System.out.print(t + "\t");
        }
        System.out.println();

        int[] array2 = Arrays.copyOf(array1, array1.length);
        for (int i = 0; i < array2.length; i++) {
            if (i / 2 == 0) {
                array2[i] = i;
            }
        }
        System.out.print("array2中的数：");
        for (int t :
                array2) {
            System.out.print(t + "\t");
        }
        System.out.println();

        array2 = array1;
        for (int i = 0; i < array2.length; i++) {
            if (i / 2 == 0) {
                array2[i] = i;
            }
        }
        for (int i = 0; i < array2.length; i++) {
            if (i / 2 == 0) {
                array2[i] = i;
            }
        }
        System.out.print("array1中的数：");
        for (int t :
                array1) {
            System.out.print(t + "\t");
        }
    }
}
