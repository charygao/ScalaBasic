package cn.lesion.spark.scala.mySpark;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
    private static final String IP_ADDR = "192.168.1.3";//服务器地址
    private static final int PORT = 8081;//服务器端口号

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        SocketAddress remoteAddr = new InetSocketAddress("192.168.1.3",8000);
        socket.connect(remoteAddr, 60000);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());


        for (int i = 0; i < 0; i++) {
            out.write(i);

        }

    }
}