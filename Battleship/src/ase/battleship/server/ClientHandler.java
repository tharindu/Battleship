package ase.battleship.server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * <code>ClientHandler</code> class handles multiple client connections in
 * different threads.
 * @author tharindu
 */
public class ClientHandler extends Thread {
    private Socket socket;
    /**
     * Creates the client hander at specified socket.
     * @param socket the socket in which server listens for a client
     */
    public ClientHandler(Socket socket)
    {
        this.socket = socket;
    }

    public void run()
    {
        try {
            //TODO: change this to read byte by byte
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                String input = in.readLine();
                Logger.getLogger(ClientHandler.class.getName()).log(Level.INFO, "Request :" + input);
                if (input == null) {
                    break;
                } else {
                    out.println(processRequest(input));
                    out.flush();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, "Could not read / write to specified socket successfully", ex);
        }
    }
    //TODO: Process Request and get a byte array
    /**
     * Processes the client request from server.
     */
    public String processRequest(String request) {
        return "NOT IMPLEMENTED";
    }

}