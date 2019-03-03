package lesson6.homework.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Server is started");
            //Server starts on port 3345
            ServerSocket server = new ServerSocket(3345);

            // We waiting connection with client.
            Socket client = server.accept();

            System.out.println("Connection was successful statemented");

            // Stream uses to send message
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("DataoutputStream is created");

            // Stream uses to receive message
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            System.out.println("DatainputStream is created");

            while (!client.isClosed())
            {
                System.out.println("Server reading info from client");
                String msg = dataInputStream.readUTF();
                System.out.println("Read info from client: " + msg);

                if (msg.equalsIgnoreCase("quit"))
                {
                    System.out.println("Client exited");
                    dataOutputStream.writeUTF("OK. I heard");
                    dataOutputStream.flush();
                    Thread.sleep(5000);
                    break;
                }

                Thread.sleep(2000);
                dataOutputStream.writeUTF("Server is waiting info from you ");
                dataOutputStream.flush();
                System.out.println("Server is waiting info from client ");

            }

            System.out.println("Client disconnected");

            dataInputStream.close();
            dataOutputStream.close();

            client.close();

            System.out.println("Finish");

        }
        catch (Exception e)
        {
            System.out.println("Something is wrong");
            e.printStackTrace();
        }
    }
}

