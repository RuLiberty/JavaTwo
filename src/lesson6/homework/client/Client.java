package lesson6.homework.client;

import java.io.*;
import java.net.Socket;

public class Client
{
    public static void main(String[] args)
    {

        try{
            Socket s = new Socket("localhost", 8888);
            System.out.println("connect to server...");
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name!");
            String name = br.readLine();
            dataOutputStream.writeUTF(name);
            dataOutputStream.flush();

            System.out.println("Client connected with server");

            try {
                Thread threadHeard = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (!s.isClosed()) {
                                String msg = dataInputStream.readUTF();
                                System.out.println("Server say: " + msg);
                                System.out.println();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                            System.out.println("Unknown error!");
                        }
                    }
                });

                threadHeard.start();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unknown error!");
            }


            while (!s.isOutputShutdown())
            {
                if (br.ready())
                {
                    String msg = br.readLine(); // чтение сроки
                    dataOutputStream.writeUTF(msg); // отправление сообщения серверу
                    dataOutputStream.flush(); // очистка

                    if (msg.equalsIgnoreCase("quit"))
                    {
                        System.out.println("Client kill connection");
                        break;
                    }
                }
            }

            System.out.println("Connection is closed");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error on Client");
        }

    }
}
