package ELSE.Day21.Reflect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import ELSE.Day21.Bean.Apple;
import ELSE.Day21.Bean.Fruit;
import ELSE.Day21.Bean.Juicer;
import ELSE.Day21.Bean.Orange;

public class Test02_Fruit {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Juicer juicer = new Juicer();
        //需要什么水果,就实例化该水果对应的对象
        //Fruit f = new Apple();


        //不使用new方式去创建对象,使用反射来实例化对象
        //首先获取到水果类的字节码对象 利用配置文件 指定 传入的水果类
        //读取配置文件
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\DroidEye\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\ELSE\\Day21\\Fruit\\fruit.properties")
        ));
        //根据类的全包名,获取对应的字节码对象
        Class<Fruit> aClass = (Class<Fruit>) Class.forName(br.readLine());
        br.close();

        // 根据一个字节码对象,创建本类的对象,默认调用无参的构造方法
        Fruit f = aClass.newInstance();
        //使用榨汁机榨汁
        juicer.run(f);


    }
}
