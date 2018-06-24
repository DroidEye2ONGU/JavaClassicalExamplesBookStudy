package crazyBook.C8.C8_8;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);

        Collections.reverse(nums);//将List集合元素的次序反转
        System.out.println(nums);

        Collections.sort(nums); //将List集合元素按自然顺序排序
        System.out.println(nums);

        Collections.shuffle(nums); //将List集合元素按随即顺序排序
        System.out.println(nums);
    }
}
