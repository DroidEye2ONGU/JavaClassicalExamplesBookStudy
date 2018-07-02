package ELSE.Day20.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 搭建一个TCP服务器
 * */
/*
 * * 创建ServerSocket(需要指定端口号)
 *  调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
 *  调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
 *  输入流可以读取客户端输出流写出的数据
 *  输出流可以写出数据到客户端的输入流
 *  操作完成，关闭资源
 * */
public class Test05_Server {
    public static void main(String[] args) throws IOException {
        // 实例化一个套接字对象,传入Prot端口号
        ServerSocket server = new ServerSocket(10000);

        //服务器可以为多个客户端提供服务 [同时提供服务]
        //利用多线程
        while (true) {
            final Socket socket = server.accept();//逐个提供服务
            // 将服务器同时给大家提供服务的代码 放到线程处理函数的内部
            new Thread(() -> {
                try {
                    //通过方法调用socket scoket是一个局部变量,
                    //需要给socket设置成final,若不加final默认
                    //作为final处理,但不能再改变socket的值,即
                    //加不加final,socket变量本质上还是一个final变量
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));

                    ps.println("欢迎访问");
                    String message = br.readLine();
                    System.out.println("收到客户端消息:" + message);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // 关闭资源
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();

        }
        //最后关闭资源
        //关闭socket自动处理IO流资源
        // server.close();


    }
}
