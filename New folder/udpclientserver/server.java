/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclientserver;
import java.io.*;
import java.net.*;
/**
 *
 * @author mrspr
 */
public class server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a datagram socket
            socket = new DatagramSocket(12345);

            // Create a byte array to receive the message
            byte[] receiveData = new byte[1024];

            while (true) {
                // Create a datagram packet to receive the message
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Receive the packet from the client
                socket.receive(receivePacket);

                // Convert the message to a string
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Print the message
                System.out.println("Message from client: " + message);

                // Get the IP address and port of the client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Create a byte array to store the response
                String response = "Hello from server";
                byte[] sendData = response.getBytes();

                // Create a datagram packet to send the response
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                // Send the packet to the client
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the socket
            if (socket != null) {
                socket.close();
            }
        }
    }
}
