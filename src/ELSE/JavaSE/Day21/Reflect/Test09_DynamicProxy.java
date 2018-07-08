package ELSE.JavaSE.Day21.Reflect;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import ELSE.JavaSE.Day21.Bean.Student;

/*
 * 动态代理模式
 * */
public class Test09_DynamicProxy {
    public static void main(String[] args) {
        // 实例化一个具体对象
        Inter obj = new StuManager();

        // 获取字节码对象
        Class<?> aClass = obj.getClass();
        //参数1:由字节码对象获得类加载器
        ClassLoader classLoader = aClass.getClassLoader();
        //参数2:所有公共接口
        Class<?>[] interfaces = aClass.getInterfaces();


        // 动态代理实现功能
        Inter proxy = (Inter) Proxy.newProxyInstance(classLoader, interfaces,
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //控制功能
                        System.out.println("日志输出:" + method.getName() + "开始操作...");

                        //拿到返回值
                        Object o = method.invoke(obj, args);//obj.method(args)

                        System.out.println("日志输出:" + method.getName() + "操作已经完成...");

                        return o;
                    }
                });

        // 通过代理对象proxy 实现功能
        proxy.save(new Student("zd", 19));// 自动执行invoke方法
        System.out.println();
        proxy.delete(12);
        System.out.println();
        proxy.update(new Student("ww",20));
    }
}

interface Inter {
    public void save(Student s);

    public void delete(int id);

    public void update(Student s);
}


class StuManager implements Inter {
    //借助代理类 实现功能的基础上,进行额外的控制[操作前后输出日志]

    @Override
    public void save(Student s) {
        // 日志输出
        System.out.println("添加学生:" + s);
        // 日志输出

    }

    @Override
    public void delete(int id) {
        // 日志输出
        System.out.println("删除学生...学号:" + id);
        // 日志输出

    }

    @Override
    public void update(Student s) {
        // 日志输出
        System.out.println("更新学生:" + s);
        // 日志输出

    }
}

/*
class ProxyManager implements Inter {
    private Inter inter;

    public ProxyManager(Inter inter) {
        this.inter = inter;
    }

    @Override
    public void save(Student s) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Student s) {

    }
}*/
