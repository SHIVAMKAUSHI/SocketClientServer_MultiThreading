package singlethreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void run(){
        Integer port=8010;
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            while (true){
                System.out.println("singlethreaded.Server is Listening...");
                Socket socket = serverSocket.accept();
                System.out.println("singlethreaded.Server is connected with "+socket.getRemoteSocketAddress());
                PrintWriter toClient= new PrintWriter(socket.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                toClient.println("Hello singlethreaded.Client....I a your singlethreaded.Server");
                toClient.close();
                fromClient.close();
                socket.close();
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            new Server().run();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
