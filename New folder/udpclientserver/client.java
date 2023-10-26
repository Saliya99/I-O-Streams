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
public class client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a datagram socket
            socket = new DatagramSocket();

            // Get the IP address of the server
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Create a byte array to store the message
            String message = "Hello from client";
            byte[] sendData = message.getBytes();

            // Create a datagram packet to send the message
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 12345);

            // Send the packet to the server
            socket.send(sendPacket);

            // Create a byte array to receive the response from the server
            byte[] receiveData = new byte[1024];

            // Create a datagram packet to receive the response
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive the packet from the server
            socket.receive(receivePacket);

            // Convert the response to a string
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Print the response
            System.out.println("Response from server: " + response);
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
