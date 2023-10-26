/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverheadquarterclientbranchesudp;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mrspr
 */
public class headquarter {

    private static final int PORT = 12345;
    private static Map<String, Double> priceMap;
    private static Map<String, Double> discountMap;

    public static void main(String[] args) {
        // Initialize the price map and discount map
        initializeMaps();

        try {
            // Create a datagram socket
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Headquarters server started on port " + PORT);

            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                // Receive the item code from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String itemCode = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Get the initial price, discount, and final price from the maps
                double initialPrice = priceMap.getOrDefault(itemCode, 0.0);
                double discount = discountMap.getOrDefault(itemCode, 0.0);
                double finalPrice = initialPrice - (initialPrice * discount / 100);

                // Send the results to the client
                String result = "Initial Price: " + initialPrice + ", Discount: " + discount + "%, Final Price: " + finalPrice;
                sendData = result.getBytes();
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeMaps() {
        priceMap = new HashMap<>();
        priceMap.put("MI001", 2500.00);
        priceMap.put("MT002", 1200.00);
        priceMap.put("MI003", 350.00);
        priceMap.put("MI004", 990.00);
        priceMap.put("ES001", 4000.00);
        priceMap.put("ES002", 3400.00);
        priceMap.put("ES003", 6500.00);
        priceMap.put("ES004", 1500.00);
        priceMap.put("MLS001", 750.00);
        priceMap.put("MLS002", 4500.00);

        discountMap = new HashMap<>();
        discountMap.put("W001", 5.0);
        discountMap.put("MT002", 2.5);
        discountMap.put("MT003", 0.0);
        discountMap.put("MT004", 2.0);
        discountMap.put("ES001", 10.0);
        discountMap.put("ES002", 7.5);
        discountMap.put("ES003", 15.0);
        discountMap.put("ES004", 5.0);
        discountMap.put("MLS001", 0.0);
        discountMap.put("MLS002", 10.0);
    }
}
