package ELSE.Day4;/*
 *{2, 5, -5, 98, 198, 43}
 *1）选择排序:
 *2）冒泡排序:
 *3）插入排序:
 * */

public class Sort {

    public static void selectSort(int[] a) {
        int minIndex = 0;


        if (a == null || a.length == 0) return;

        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int t = a[i];
            a[i] = a[minIndex];
            a[minIndex] = t;
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {//循环a.length - 1趟
            for (int j = 0; j < a.length - i - 1; j++) {//-1为了防止溢出
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        if (a == null || a.length < 2) return;

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                } else {
                    break;
                }
            }
        }


    }

    public static void main(String[] args) {
        int[] a = {1, 54, 68, 94, 0, 12, 4};
        selectSort(a);
        System.out.print("选择排序：");
        for (int t :
                a) {
            System.out.print(t + "\t");
        }
        System.out.println("\n-------------------------------------------------------");


        a = new int[]{1, 54, 68, 94, 0, 12, 4};
        bubbleSort(a);
        System.out.print("冒泡排序：");
        for (int t :
                a) {
            System.out.print(t + "\t");
        }
        System.out.println("\n-------------------------------------------------------");


        a = new int[]{1, 54, 68, 94, 0, 12, 4};
        insertionSort(a);
        System.out.print("插入排序：");
        for (int t :
                a) {
            System.out.print(t + "\t");
        }
    }

}
