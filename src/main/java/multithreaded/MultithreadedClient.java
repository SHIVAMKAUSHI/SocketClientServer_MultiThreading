package multithreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultithreadedClient {
    public Runnable getRunnable()  {
        return ()->{
            Integer port=8010;
            try {
                InetAddress inetAddress= InetAddress.getByName("localhost");
                Socket socket = new Socket(inetAddress,port);
                PrintWriter toServer = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                toServer.println("Hello from Client : "+socket.getLocalSocketAddress());
                System.out.println(fromServer.readLine());

                toServer.close();
                fromServer.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

    }

    public static void main(String[] args) {
        try{

            int i=0;
            MultithreadedClient multithreadedClient = new MultithreadedClient();

            while (i<=100){
                Thread t1 =new Thread(multithreadedClient.getRunnable());
                t1.start();
                i++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
