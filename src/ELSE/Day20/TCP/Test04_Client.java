package ELSE.Day20.TCP;

/*
* 搭建一个TCP客户端
*
* * 创建Socket连接服务端(指定ip地址,端口号)通过ip地址找对应的服务器
    * 调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
    * 输入流可以读取服务端输出流写出的数据
    * 输出流可以写出数据到服务端的输入流
    * 操作完成，关闭资源
* */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;

public class Test04_Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",10000); // 填入服务器的ip和端口号

        //获取通信IO流
       /* InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        PrintStream ps = new PrintStream(os);*/
       //简化获取IO的写法
        PrintStream ps = new PrintStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //按照逻辑去接收发送数据
        //先收取服务器发来的信息
       /* byte[] buff = new byte[1024];
        int len;
        len = is.read(buff);// 如果对方发了信息,则read成功
                            // 如果对方没发信息,则read阻塞*/

        String message = br.readLine();
        System.out.println("从服务器收到信息:" + message);

        //再发送请求给服务器
        ps.println("我想咨询实训事宜");
        //os.write("我想咨询实训事宜".getBytes());

        //关闭资源
        socket.close();

        /*
        int port = socket.getLocalPort();
        System.out.println("客户端port:"+port);
        */
    }
}
