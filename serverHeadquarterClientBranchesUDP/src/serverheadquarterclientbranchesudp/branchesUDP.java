/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverheadquarterclientbranchesudp;
import java.net.*;
import java.io.*;
/**
 *
 * @author mrspr
 */
public class branches {
     private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create a datagram socket
            DatagramSocket clientSocket = new DatagramSocket();

            // Get the IP address of the server
            InetAddress IPAddress = InetAddress.getByName(SERVER_IP);

            byte[] sendData;
            byte[] receiveData = new byte[1024];

            // Read the item code from the user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter item code: ");
            String itemCode = userInput.readLine();
            sendData = itemCode.getBytes();

            // Send the item code to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, SERVER_PORT);
            clientSocket.send(sendPacket);

            // Receive and print the results from the server
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println(result);

            // Close the client socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
