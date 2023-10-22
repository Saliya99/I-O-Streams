/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferfileclntsrvr;

import java.io.*;
import java.net.*;
/**
 *
 * @author mrspr
 */
public class TransferFileClntSrvr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket serverSocket = null;
        try {
            // Create a server socket
            serverSocket = new ServerSocket(12345);

            // Accept a connection from the client
            Socket socket = serverSocket.accept();

            // Get the input stream of the socket
            InputStream is = socket.getInputStream();

            // Write the input stream to a file
            FileOutputStream fos = new FileOutputStream("C:\\Users\\mrspr\\Documents\\NetBeansProjects/copy.txt");
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // Close the file output stream
            fos.close();

            // Close the socket input stream
            is.close();

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
