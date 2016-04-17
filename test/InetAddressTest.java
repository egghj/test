package cn.longyt.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class InetAddressTest {

    @Test
    public void test001() {
        try {
            // 使用域名创建对象
            InetAddress inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);
            // 使用IP创建对象
            InetAddress inet2 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet2);
            // 获得本机地址对象
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);
            // 获得对象中存储的域名
            String host = inet3.getHostName();
            System.out.println("域名：" + host);
            // 获得对象中存储的IP
            String ip = inet3.getHostAddress();
            System.out.println("IP:" + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test002() {
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        // 服务器端IP地址
        String serverIP = "127.0.0.1";
        // 服务器端端口号
        int port = 10000;
        // 发送内容
        String data = "Hello";
        try {
            // 建立连接
            socket = new Socket(serverIP, port);
            // 发送数据
            os = socket.getOutputStream();
            os.write(data.getBytes());
            // 接收数据
            is = socket.getInputStream();
            byte[] b = new byte[1024];
            int n = is.read(b);
            // 输出反馈数据
            System.out.println("服务器反馈：" + new String(b, 0, n));
        } catch (Exception e) {
            System.out.println("连接服务器异常！");
            e.printStackTrace(); // 打印异常信息
        } finally {
            try {
                // 关闭流和连接
                is.close();
                os.close();
                socket.close();
            } catch (Exception e2) {
            }
        }
    }
}
