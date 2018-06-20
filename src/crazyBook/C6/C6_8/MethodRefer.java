package crazyBook.C6.C6_8;

import javax.swing.*;

@FunctionalInterface
interface Converter{
    Integer convert(String form);
}

@FunctionalInterface
interface MyTest {
    String test(String a, int b, int c);
}

@FunctionalInterface
interface YourTest {
    JFrame win(String title);
}

public class MethodRefer {
    public static void main(String[] args) {
    //1.引用类方法

        //下面代码使用Lambda表达式创建Converter对象
        //由于表达式所实现的convert()方法需要返回值,因此
        //Lambda表达式将会把这条代码的值作为返回值
        /*Converter converter1 = form -> Integer.valueOf(form);*/
        Converter converter1 = Integer::valueOf;

        Integer val = converter1.convert("99");
        System.out.println(val);


    //2.引用特定对象的实例方法

        //下面代码使用Lambda表达式创建Converter对象
        /*Converter converter2 = form -> "DroidEye".indexOf(form);*/
        //方法引用代替Lambda表达式:引用特定对象的实例方法
        Converter converter2 = "DroidEye"::indexOf;
        /*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
        *对于上面实例方法的引用,也就是调用"DroidEye"对象的indexOf()实例方法
        * 来实现Converter函数式接口中唯一的抽象方法,当调用Converter接口中唯
        * 一的抽象方法时,调用参数将会传给"DroidEye"对象的indexOf()实例方法
        * */

        Integer value = converter2.convert("ye");
        System.out.println(value);


    //3.引用某类对象的实例方法

        //该函数式接口中包含一个test()抽象方法,该方法负责根据String,int,int
        //三个参数生成一个String返回值.
        //下面代码使用Lambda表达式来创建一个MyTest对象
        //下面Lambda表达式的代码块只有一条语句,因此程序省略了该代码块的花括号;
        //而且由于表达式所实现的test()方法需要返回值,因此Lambda表达式将会把这
        //条代码的值作为返回值

        //形参名不用与接口中抽象方法中的形参名相同,
        //但()圆括号中的属性顺序与接口中抽象方法的形参一一对应
        //在圆括号中也可以省略传入实参的属性

        /*MyTest mt = (a, b, c) -> a.substring(b, c);*/
        //上面Lambda表达式的代码块只有一行a.subString(b,c);,因此可以使用
        //如下方法引用进行替换
        //方法引用替代Lambda表达式:引用某类对象的实例方法
        //函数式接口中被实现方法的第一个参数作为调用者
        //后面的参数全部传给方法作为参数
        MyTest mt = String::substring;
        /*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
        * 对于上面的实例方法引用,也就是调用某个String对象的substring()实例方法
        * 来实现MyTest函数式借口中唯一的抽象方法,当调用MyTest接口中唯一的抽象方
        * 法时,第一个调用的参数将作为substring方法的调用者,剩下的调用参数会作为
        * substring()实例方法的调用参数
        * */

        String str = mt.test("Java I Love you", 2, 9);
        System.out.println(str);

    //4.引用构造器

        //该函数式接口中含有一个win()抽象方法,该方法根据String参数生成一个
        //JFrame返回值

        //下面代码使用Lambda表达式创建YourTest对象

        //下面Lambda表达式的代码块只有一条语句,因此省略了该代码块的花括号;
        //而且由于表达式所示现的win()方法需要返回值,因此Lambda表达式将会把
        //这条代码的值作为返回值
        /*YourTest yt = (a) -> new JFrame(a);*/
        //上面Lambda表达式的代码块只有一行new JFrame(a);,因此可以使用如下
        //构造器引用进行替换

        //构造器引用代替Lambda表达式
        //函数式接口中被实现方法的全部参数传给该构造器作为参数
        YourTest yt = JFrame::new;

        //下面代码调用yt对象的win()方法时,由于yt对象时Lambda表达式创建的,
        //因此win()方法之形体就是Lambda表达式的代码块部分,即执行体就是
        //new JFrame(a);语句,并将这条语句的值作为方法的返回值
        JFrame jf = yt.win("我的窗口");
        System.out.println(jf);
    }
}
