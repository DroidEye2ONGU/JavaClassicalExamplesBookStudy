package ELSE.Day4;

/*
*
* 写ArrayMultipy.java，使用数组，在数组元素中保存1到10，然后将所有数组元素相乘并输出结果。
*
*
* */
public class ArrayMultipy {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int mul = 1;
        for (int t :
                a) {
            mul *= t;
        }

        System.out.println("数组中所有元素的乘积为：" + mul);
    }

}
