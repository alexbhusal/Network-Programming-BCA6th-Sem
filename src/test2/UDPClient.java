package test2;

import java.net.*;

public class UDPClient {

    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket()) {

            byte[] buf = "Hello UDP Server".getBytes();

            InetAddress address = InetAddress.getByName("localhost");

            socket.send(new DatagramPacket(buf, buf.length, address, 9876));

            byte[] respBuf = new byte[1024];

            DatagramPacket response = new DatagramPacket(respBuf, respBuf.length);

            socket.receive(response);

            System.out.println("Server response: " + new String(response.getData(), 0, response.getLength()));

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }

    }

} 