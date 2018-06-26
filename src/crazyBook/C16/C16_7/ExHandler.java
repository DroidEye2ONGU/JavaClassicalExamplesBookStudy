package crazyBook.C16.C16_7;

// 定义自己的异常处理器
class MyExHandler implements Thread.UncaughtExceptionHandler {
    // 实现uncaughtException()方法,该方法将处理线程的未处理异常
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " 线程出现了异常:" +  e);
    }
}

public class ExHandler {
    public static void main(String[] args) {
        // 设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler(
                new MyExHandler()
        );
        int a = 5 / 0;
        System.out.println("程序正常结束!");
    }
}

/*
* 输出:Thread[main,5,main] 线程出现了异常:java.lang.ArithmeticException: / by zero
    可以看到虽然程序指定了异常处理器对未捕获的异常进行处理,而且该异常处理器也确实其作用了,
    但程序依然不会正常结束。这说明异常处理器与通过catch捕获异常是不同的——当使用catch捕获异常
    时，异常不会向上传播给上一级调用者；但使用异常处理器对异常进行处理之后，异常依然会传播给
    上一级调用者。
 * */
