package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
    public Socket runServerByPort(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running and waiting for client connections...");
        return serverSocket.accept();
    }

    public void connectionToSite(String host, int port) {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String questionFirst = in.readLine();
            System.out.println(questionFirst);

            String answerFirst = "Ivan Ivanov";
            out.println(answerFirst);

            String responseFirst = in.readLine();
            System.out.println(responseFirst);

            String questionSecond = in.readLine();
            System.out.println(questionSecond);

            String answerSecond = "no";
            out.println(answerSecond);

            String responseSecond = in.readLine();
            System.out.println(responseSecond);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
