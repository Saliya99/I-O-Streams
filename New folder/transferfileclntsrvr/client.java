/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferfileclntsrvr;
// Client.java
import java.io.*;
import java.net.*;

/**
 *
 * @author mrspr
 */
public class client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // Create a socket
            socket = new Socket("localhost", 12345);

            // Get the file
            File file = new File("C:\\Users\\mrspr\\Documents\\NetBeansProjects/original.txt");
            FileInputStream fis = new FileInputStream(file);

            // Get the output stream of the socket
            OutputStream os = socket.getOutputStream();

            // Write the file to the output stream
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            // Close the file input stream
            fis.close();

            // Close the socket output stream
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the socket
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
