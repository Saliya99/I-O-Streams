/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverClient;
import java.io.*;
import java.net.*;
/**
 *
 * @author mrspr
 */
public class branches {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
         try {
            // Create a socket to connect to the server
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            // Create input and output streams for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the item code from the user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter item code: ");
            String itemCode = userInput.readLine();

            // Send the item code to the server
            out.println(itemCode);

            // Read and print the results from the server
            String initialPrice = in.readLine();
            String discount = in.readLine();
            String finalPrice = in.readLine();

            System.out.println("Initial Price: " + initialPrice);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);

            // Close the socket
            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}