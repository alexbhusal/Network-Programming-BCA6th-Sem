package test2;

import java.net.*;

public class UDPServer {

    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket(9876)) {

            byte[] buffer = new byte[1024];

            System.out.println("Server running...");

            DatagramPacket request = new DatagramPacket(buffer, buffer.length);

            socket.receive(request);

            String msg = new String(request.getData(), 0, request.getLength());

            System.out.println("Received: " + msg);

            byte[] reply = "Hello from Server".getBytes();

            socket.send(new DatagramPacket(reply, reply.length, request.getAddress(), request.getPort()));

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }

    }

} 