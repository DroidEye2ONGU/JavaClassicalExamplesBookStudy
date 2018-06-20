package crazyBook.C6.C6_9;
/*

public enum Gender implements GenderDesc{
    MALE("男"),FEMALE("女");
    //定义一个public修饰的实例变量
    private final String name;

    //枚举类的构造器只能使用private修饰
    private Gender(String name) {
        this.name = name;
    }

    */
/*public void setName(String name) {
        switch (this) {
            case MALE:
                if (name.equals("男")) {
                    this.name = name;
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
            case FEMALE:
                if (name.equals("女")) {
                    this.name = "女";
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
        }
    }
*//*

    public String getName() {
        return this.name;
    }

    @Override
    public void info() {
        System.out.println("这是一个用于定义性别的枚举类");
    }
}
*/

/*
* 如果需要每个枚举值在调用该方法时呈现出不同的行为方式,则可以让每个枚举值分别来
* 实现该方法
* */
public enum Gender implements GenderDesc {
    MALE("男") {
        //花括号部分实际上是类体的一部分
        @Override
        public void info() {
            System.out.println("这个枚举类代表男性");
        }
    },
    FEMALE("女"){
        @Override
        public void info() {
            System.out.println("这个枚举类代表女性");
        }
    };

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
