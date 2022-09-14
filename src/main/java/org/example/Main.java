package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        System.out.println("Server started");
        int port = 8888;

        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String text = in.readLine();
                    text=newConnect(text);
                    out.println(text);
                }
            }
        } catch (IOException e){
            e.printStackTrace();;
        }
    }
    public static String newConnect(String text) {
        System.out.println("<- "+text);
        switch (text) {
            case "Hello!": text="Let's talk"; break;
            case "ok": text="where are you from?"; break;
            case "from Russia": text="i, too"; break;
            case "bye":text="bye";break;
            default:
                text="...";
        }
        System.out.println("-> "+text);
        return text;
    }
}