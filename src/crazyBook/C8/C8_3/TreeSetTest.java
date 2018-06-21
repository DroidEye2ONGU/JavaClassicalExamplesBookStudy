package crazyBook.C8.C8_3;

import java.util.TreeSet;
/*
* ①如果试图把一个对象添加到TreeSet时,则该对象的类必须实现Comparable接口,
* 否则程序将会抛出异常
*
* ②只添加一个元素时,无需实现Comparable接口,后面添加的元素都必须实现Comparable接口,
* 但取出的时候会引发ClassCastException异常
*
* ③由于比较对象时必须是相同元素,所以如果在TreeSet中存储不同类型的元素时,取出的时候
* 就会引发ClassCastException异常,也就是②中引发异常的原因.
* 总结起来就是一句话:如果希望TreeSet能正常运作,TreeSet只能添加同一种类型的对象
*
* ④对于TreeSet集合而言,它判断两个对象是否相等的唯一标准是:两个对象通过
* compareTo(Object obj)方法比较是否返回0--如果通过compareTo(Object obj)方法
* 比较返回0,TreeSet则会认为它们相等,否则就认为它们不相等
*
* ⑤当需要把一个对象放入TreeSet中,重写该对象对应的equals()方法时,应保证该方法与
* compareTo(Object obj)方法有一致的结果,其规则是:如果两个对象通过equals()方法
* 比较返回true时,这两个对象通过compareTo(Object obj)方法比较应返回0
*
* ⑥一旦改变了TreeSet集合里可变元素的实例变量,当再试图删除该对象时,TreeSet也会
* 删除失败(甚至集合中原有的,实例变量没被修改但与修改后元素相等的元素也无法删除),
* 所以TreeSet可以删除没有被修改实例变量,且不与其他被修改实例变量的对象重复的对象
*
* ⑦与HashSet类似的是,如果TreeSet中包含了可变对象,当可变对象的实例变量被修改时,
* TreeSet在处理这些对象时将非常复杂,而且容易出错.为了让程序更加健壮,推荐不要修改
* 放入HashSet和TreeSet集合中元素的关键实例变量.
* */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> nums = new TreeSet();
        //向TreeSet中添加四个Integer对象
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        //输出集合元素,看到集合元素已经处于排序状态
        System.out.println(nums);

        //输出集合里的第一个元素
        System.out.println(nums.first());

        //输出集合里的最后一个元素
        System.out.println(nums.last());

        //返回小于4的子集,不包括4
        System.out.println(nums.headSet(4));

        //返回大于5的子集,如果Set中包含5,自己中还包含5
        System.out.println(nums.tailSet(5));

        //返回大于等于-3,小于4的子集 左闭右开
        System.out.println(nums.subSet(-3, 4));
    }
}
