package ELSE.Day20.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
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
public class Test01_Server {
    public static void main(String[] args) throws IOException {
        // 实例化一个套接字对象,传入Prot端口号
        ServerSocket server = new ServerSocket(10000);
        System.out.println(server);
        // 接收客户端的连接 返回一个通信的socket
        // 专门负责与指定的客户端通信
        Socket socket = server.accept(); // 如果有客户端连接上来则返回
                                         // 如果没有连接,则等待,一直到有客户端连接

        //获取 输入输出流[负责服务器与客户端通信]
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //客户端连接到服务器,服务器先返回一个信息给客户端:欢迎访问
        os.write("欢迎访问".getBytes());//发送数据给客户端

        //客户端收到以后,再发送消息给服务器,我想咨询实训事宜
        byte[] buf = new byte[1024];
        int len;
        len = is.read(buf);
        System.out.println("收到客户端消息:" + new String(buf, 0, len));

        //最后关闭资源
        socket.close();//关闭socket自动处理IO流资源
        server.close();








      /*  System.out.println(socket);
        int port = socket.getLocalPort();*/

        //Local是本机的意思
        /*InetAddress address = socket.getLocalAddress();
        String ip = address.getHostName();
        System.out.println("localIp: " + ip + ",port:" + port);*/

        //获取到客户端的ip地址和port
        /*int cPort = socket.getPort();
        String cIp = socket.getInetAddress().getHostName();
        System.out.println("cip:" + cIp + ",cPort:" + cPort);*/
    }
}
