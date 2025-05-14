package com.ppt;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 4000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            while (true) {
                // Accept client connections in a loop
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                // Handle client in a separate thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Set socket options
            socket.setTcpNoDelay(true);       // Disable Nagle's algorithm
            socket.setSoLinger(true, 5);      // Linger for 5 seconds on close
            socket.setSoTimeout(5000);        // Read timeout of 5 seconds

            // Read data from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Message received: >>>>> " + message);
            }

            socket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
