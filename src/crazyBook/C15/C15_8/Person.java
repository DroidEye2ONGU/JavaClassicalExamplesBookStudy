package crazyBook.C15.C15_8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Person implements Serializable {
    private static final long serialVersionUID = -8406729319427226191L;
    private String name;
    //transient关键字
    //只能用于修饰实例变量,不可修饰java程序中其他部分
    //通过在实例变量前面使用transient关键字修饰,可以指定java序列化时无须理会该实例变量
    //private transient int age;

    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    //重写 writeObject方法,程序在序列化该对象之前,先调用该方法
    /*
     * Java的序列化机制保证在序列化某个对象之前,先调用该对象的
     * writeReplace()方法,如果该方法返回另一个Java对象,则系统
     * 转为序列化另一个对象
     * */
    /*
     * 下面方法表面是序列化Person对象,但实际上序列化的是ArrayList
     * */
   /* private Object writeReplace() throws ObjectStreamException {
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }*/

    private void writeObject(ObjectOutputStream outputStream)
            throws IOException {
        //将name实例变量反转后写入二进制流
        outputStream.writeObject(
                new StringBuffer(name).reverse()
        );
        outputStream.writeInt(age);
    }

    private void readObject(ObjectInputStream objectInputStream)
            throws IOException, ClassNotFoundException {
        //将读取的字符串反转后赋给name实例变量
        this.name = ((StringBuffer) objectInputStream.readObject()).reverse()
                .toString();
        this.age = objectInputStream.readInt() + 1;


    }
}

