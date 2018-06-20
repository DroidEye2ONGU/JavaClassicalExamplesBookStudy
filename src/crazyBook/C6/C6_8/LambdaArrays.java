package crazyBook.C6.C6_8;

import java.util.Arrays;

public class LambdaArrays {
    public static void main(String[] args) {
        String[] arr1 = new String[]{
                "java",
                "fkjava",
                "fkid",
                "ios",
                "android"
        };

        // 下面这行代码的Lambda表达式的目标类型是Comparator,
        // 该Comparator指定了判断字符串大小的标准:
        // 字符串越长,即可认为该字符串越大;
        Arrays.parallelSort(arr1,
                (o1,o2)->o1.length() - o2.length());
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{3, -4, 25, 16, 30, 18};
        // left代表数组中前一个索引处的元素,计算第一个元素时,left为1
        // right代表数组中当前索引处的元素

        //下面这行代码的Lambda表达式的目标类型是IntBinaryOperator
        //该对象会根据前后两个元素计算当前元素的值
        Arrays.parallelPrefix(arr2,
                (left, right) -> left * right);
        System.out.println(Arrays.toString(arr2));

        long[] arr3 = new long[5];
        //下面这行代码的Lambda表达式的目标类型时IntToLongFunction,
        //该对象会根据元素的索引来计算当前元素的值
        Arrays.parallelSetAll(arr3, operand -> operand * 5);
        System.out.println(Arrays.toString(arr3));
    }//p220
}
