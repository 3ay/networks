package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("netology.homework", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);
            String name = userInputReader.readLine();
            out.println(name);

            serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);

            String answer = userInputReader.readLine();
            out.println(answer);

            serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





