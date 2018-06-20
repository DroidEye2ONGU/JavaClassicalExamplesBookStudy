package crazyBook.C6.C6_9;

public enum Gender implements GenderDesc{
    MALE("男"),FEMALE("女");
    //定义一个public修饰的实例变量
    private final String name;

    //枚举类的构造器只能使用private修饰
    private Gender(String name) {
        this.name = name;
    }

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
*/
    public String getName() {
        return this.name;
    }

    @Override
    public void info() {
        System.out.println("这是一个用于定义性别的枚举类");
    }
}
