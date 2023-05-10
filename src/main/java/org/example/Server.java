package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int myPort = 7777;
        Connection connection = new Connection();

        while (true) {
            Socket socket = connection.runServerByPort(myPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Write your name:");
            final String name = reader.readLine();
            out.println(name);
            out.println(String.format("Hi %s, your port is %d", name, socket.getPort()));

            out.println("Are you a child? (yes/no):");
            String answer = reader.readLine();
            out.println("Received answer from client: " + answer);

            String response;
            if (answer.equalsIgnoreCase("yes")) {
                response = "Welcome to the kids area, " + name + "! Let's play!";
            } else {
                response = "Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!";
            }
            out.println(response);
            out.println(reader.readLine());
            socket.close();
        }
    }
}
