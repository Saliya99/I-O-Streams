/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author mrspr
 */
public class client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 6789);
        System.out.println("Connected to the server!");

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String clientMessage = "Puka Sududa ?";
        outToServer.writeBytes(clientMessage + '\n');

        String serverMessage = inFromServer.readLine();
        System.out.println("Received from server: " + serverMessage);

        clientSocket.close();
    }
}
