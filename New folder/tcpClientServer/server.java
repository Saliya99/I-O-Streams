/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tcp;
import java.io.*;
import java.net.*;

/**
 *
 * @author mrspr
 */
public class server {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server is running and waiting for a client connection...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

        String clientMessage = inFromClient.readLine();
        System.out.println("Received from client: " + clientMessage);

        String serverMessage = "Kalui Huttoo !";
        outToClient.writeBytes(serverMessage + '\n');

        clientSocket.close();
        serverSocket.close();
    }
}