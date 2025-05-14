package com.ppt;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 4000;

        try (Socket socket = new Socket(host, port)) {
            // Set socket options
            socket.setTcpNoDelay(false);       // Disable Nagle's algorithm
            socket.setSoLinger(true, 5);      // Linger for 5 seconds on close
            socket.setSoTimeout(5000);        // Read timeout of 5 seconds

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send multiple messages to the server
            for (int i = 1; i <= 100; i++) {
                String message = "Message " + i;
                System.out.println("Sending: " + message);
                out.println(message);

                // Wait for server response
                String serverResponse = in.readLine();
                System.out.println("Server response: \n\t\t" + serverResponse);
            }

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
