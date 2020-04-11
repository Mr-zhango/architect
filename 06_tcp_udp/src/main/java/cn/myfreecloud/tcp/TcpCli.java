package cn.myfreecloud.tcp;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author: zhangyang
 * @date: 2020/4/11 18:07
 * @description:
 */
public class TcpCli {
    public static void main(String[] args) throws Exception {
        System.out.println("socket启动....");
        Socket s = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("我是客戶端....".getBytes());
        s.close();
    }

}
