package ELSE.JavaSE.Day20.UDP;
/*
* UDP发送端
* */
/*
* * 创建DatagramSocket, 随机端口号
 *  创建DatagramPacket, 指定数据, 长度, 地址, 端口
 *  使用DatagramSocket发送DatagramPacket
 *  关闭DatagramSocket
* */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Test01_Send {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String msg = "学习挖掘机哪家强";
        DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,
                InetAddress.getByName("127.0.0.1"),8888);

        ds.send(dp);

        ds.close();
    }
}
