package ase.battleship.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

/**
 * The Battleship server class that accepts incoming connections to start a battleship game.
 * @author tharindu
 */
public class BattleshipServer {
    private static Vector clientList = new Vector();
    /**
     * Creates the Battleship server at specified port.
     * @param port integer specifying the port
     */
    public BattleshipServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (Exception e) {
             Logger.getLogger(BattleshipServer.class.getName()).log(Level.SEVERE, 
                     "Server did not initiated or client handler did not created successfully", e);
        }
    }
    /**
     * Checks if the client id is already in the list.
     * @param clientId a string representing client id
     * @return true if client list contains the client id
     */
    public static boolean isAdded(String clientId) {
        return clientList.contains(clientId);
    }
    /**
     * Adds the client id to the static client list.
     * @param clientId a string giving client id
     */
    public static void addToClientList(String clientId) {
        clientList.add(clientId);
    }
    /**
     * Removes client id from the static client list.
     * @param clientId a string giving client id
     */
    public static void removeFromClientList(String clientId) {
        clientList.remove(clientId);
    }
}
