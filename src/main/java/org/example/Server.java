package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Write your name:");
            String name = in.readLine();
            System.out.println("Client: " + name);

            out.println("Are you a child? (yes/no):");
            String answer = in.readLine();
            System.out.println("Client: " + answer);

            if (answer.equalsIgnoreCase("yes")) {
                out.println("Welcome to the kids area, " + name + "! Let's play!");
            } else {
                out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
