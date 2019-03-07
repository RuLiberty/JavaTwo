package lesson7.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable
{
    private Socket clientSocket;
    private Server server;
    private PrintWriter outMsg;
    private Scanner inMsg;
    private String name;
    private static int clientCount = 0;

    private boolean isAuth = false;

    public String getName(){
        return name;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    public ClientHandler(Socket clientSocket, Server server)
    {
        try
        {
            clientCount++;
            this.clientSocket = clientSocket;
            this.server = server;
            this.outMsg = new PrintWriter(clientSocket.getOutputStream());
            this.inMsg = new Scanner(clientSocket.getInputStream());
            this.name = inMsg.nextLine();
            this.isAuth = this.auth();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        try
        {
            if (this.isAuth()) {
                server.notificationAllClientWithNewMessage("New client in our chat");
                server.notificationAllClientWithNewMessage("In our chat = " + clientCount + "clients!");


                while (true) {
                    if (inMsg.hasNext()) {
                        String clientMsg = inMsg.nextLine();
                        if (clientMsg.equalsIgnoreCase("QUIT")) {
                            break;
                        } else if (clientMsg.startsWith("\\w")) {
                            String[] tokens = clientMsg.split("\\s");
                            String toClient = tokens[1];
                            String msg = clientMsg.substring(4 + toClient.length());
                            server.sendMsgToClient(this, toClient, clientMsg);
                        } else {
                            System.out.println(clientMsg);
                            server.notificationAllClientWithNewMessage(clientMsg);
                        }
                    }
                }

                Thread.sleep(1000);
            }
            else throw new Exception("Не удалось подключится к серверу, попробуйте позднее");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            exitFromChat();
        }

    }

    private void exitFromChat()
    {
        clientCount--;
        server.notificationAllClientWithNewMessage("Client exited. In out chat = " + clientCount + " clients!");
        server.removeClient(this);
    }

    public void sendMessage(String msg)
    {
        try
        {
            outMsg.println(msg);
            outMsg.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean auth() {
        for (ClientHandler clientHandler : server.getClientHandlers()) {
            if (clientHandler.getName().equals(name)){return false;}
        }
        return true;
    }
}

