package ELSE.Day20.UDP;
/*
*  UDP接收端
* */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
* * 创建DatagramSocket, 指定端口号
 *  创建DatagramPacket, 指定数组, 长度
 *  使用DatagramSocket接收DatagramPacket
 *  从DatagramPacket中获取数据
 *  关闭DatagramSocket
* */
public class Test02_Receive {
    public static void main(String[] args)throws IOException {
        DatagramSocket ds = new DatagramSocket(8888);

        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, 1024);

        ds.receive(dp);

        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        byte[] data = dp.getData();
        String msg = new String(data);
        System.out.println(address.getHostName() + " - " + port + ":" + msg);

        ds.close();
    }
}
