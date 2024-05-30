package multithreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class MultithreadedServer {
    public Consumer<Socket> getConsumer(){
        return (s->{
            try {
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter toClient = new PrintWriter(s.getOutputStream(),true);
                toClient.println("Hello from Server");
//                System.out.println(fromClient.readLine());

                toClient.close();
                fromClient.close();
                s.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        try {
            Integer port=8010;
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening at port.... "+port );
            MultithreadedServer multithreadedServer=new MultithreadedServer();
            while(true){
                Socket socket = serverSocket.accept();
                Thread th = new Thread(()->multithreadedServer.getConsumer().accept(socket));
                th.start();
//                socket.close();

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
