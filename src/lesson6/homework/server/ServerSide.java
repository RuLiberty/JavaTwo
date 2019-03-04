package lesson6.homework.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] args) {
        try {
            //Server starts on port 3345
            ServerSocket server = new ServerSocket(3345);
            System.out.println("Server is started");

            // We waiting connection with client.
            Socket client = server.accept();
            System.out.println("Connection was successful statemented");

            // Stream uses to send message
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("DataoutputStream is created");

            // Stream uses to receive message
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            System.out.println("DatainputStream is created");
            System.out.println();
            System.out.println();

            // Reader uses to writing msg
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Thread threadHeard = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (!client.isClosed()) {
                            String msg = dataInputStream.readUTF();
                            System.out.println("Client say: " + msg);

                            if (msg.equalsIgnoreCase("quit")) {
                                System.out.println("Client exited");
                                dataOutputStream.writeUTF("OK. I heard");
                                dataOutputStream.flush();
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Unknown error!");
                    }
                }
            });

            threadHeard.start();

            while (true) {
                if (br.ready()) {
                    String msg = br.readLine(); // чтение сроки
                    dataOutputStream.writeUTF(msg); // отправление сообщения клиенту
                    dataOutputStream.flush(); // очистка
                }
                if (client.isClosed()){
                    break;
                }
            }
                    threadHeard.join();
                    System.out.println("Client disconnected");

                    dataInputStream.close();
                    dataOutputStream.close();

                    client.close();

                    System.out.println("Finish");
            } catch (Exception e) {
            System.out.println("Something is wrong");
            e.printStackTrace();
        }
        }
    }


