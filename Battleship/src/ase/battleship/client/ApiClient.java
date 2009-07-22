package ase.battleship.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Client class that sends data to server. And recieve data from server.
 * @author tharindu
 */
public class ApiClient {

    private String server;
    private int port;
    private BufferedReader inputstream;
    private DataOutputStream outputstream;

    /**
     * Creates a new API Client that could send and receive messages with Battleship Server.
     * @param server a string representing server host name
     * @param port an integer representing server port
     */
    public ApiClient(String server, int port) {
        this.server = server;
        this.port = port;
        try {
            Socket socket = new Socket(server, port);
            inputstream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputstream = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            Logger.getLogger(ApiClient.class.getName()).log(Level.SEVERE, "Could Not connect to server", ex);
        }
    }

    /**
     * Sends the message as in byte array and waits for the response. Then returns
     * the response as a string.
     * @param message the byte array containing header and body
     * @return string of response
     * @throws IOException
     */
    public String sendMessage(byte[] message) throws IOException {
        outputstream.write(message);
        //outputstream.flush();
        Logger.getLogger(ApiClient.class.getName()).log(Level.INFO, "Message has been sent successfully");
        while (true) {
            String str = inputstream.readLine();
            if (str == null) {
                break;
            } else {
                return str;
            }
        }
        return null;
    }
    /**
     * Sends the message as in byte array and does not wait for response.
     * @param message byte array of the message
     * @throws java.io.IOException
     */
    public void sendMsgOnly(byte[] message) throws IOException {
        outputstream.write(message);
        outputstream.flush();
        Logger.getLogger(ApiClient.class.getName()).log(Level.INFO, "Message has been sent successfully");
    }
}

