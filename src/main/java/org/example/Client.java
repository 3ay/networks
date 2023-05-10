package org.example;

import java.io.IOException;
import java.net.InetAddress;

public class Client {
    private static final int myPort = 7777;
    private static final String hostName = "netology.homework";

    public static void main(String[] args) throws IOException {
        Connection connection = new Connection();
        connection.connectionToSite(hostName, myPort);
        InetAddress inetAddress = InetAddress.getByName(hostName);
        System.out.println(hostName + ", ip address: " + inetAddress.getHostAddress());
    }
}
