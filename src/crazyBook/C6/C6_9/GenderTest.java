package crazyBook.C6.C6_9;

public class GenderTest {
    public static void main(String[] args) {
        //通过Enum的valueOf()方法来获取指定枚举类的枚举值
        Gender g = Enum.valueOf(Gender.class, "FEMALE");
        //直接为枚举值的name实例变量赋值
       /* g.setName("男");*/
        //直接访问枚举值的name实例变量
        System.out.println(g + "代表" + g.getName());
        g.info();
        Gender.MALE.info();
    }
}