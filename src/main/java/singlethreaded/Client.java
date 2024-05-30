package singlethreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run()throws UnknownHostException, IOException {
        Integer port=8010;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress, port);
        PrintWriter toSever = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSever = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = fromSever.readLine();
        System.out.println("Response from server : "+ line);
        fromSever.close();
        toSever.close();
        socket.close();

    }

    public static void main(String[] args) {
        try {
            new Client().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
