package lesson6.homework.client;

import java.io.*;
import java.net.Socket;

public class Client
{
    public static void main(String[] args)
    {
        try (Socket s = new Socket("localhost", 3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

             DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream()))
        {
            System.out.println("Client connected with server");


            while (!s.isOutputShutdown())
            {
                if (br.ready())
                {
                    System.out.println("Client is writing...");
                    Thread.sleep(1000);
                    String msg = br.readLine();

                    dataOutputStream.writeUTF(msg);
                    dataOutputStream.flush();
                    System.out.println("Client sent message = " + msg);
                    Thread.sleep(4000);

                    if (msg.equalsIgnoreCase("quit"))
                    {
                        System.out.println("Client kill connection");
                        Thread.sleep(2000);
                        break;
                    }

                    System.out.println("We are going to work....");

                }
            }

            System.out.println("Connection is closed");
        }
        catch (Exception e)
        {

        }

    }
}
