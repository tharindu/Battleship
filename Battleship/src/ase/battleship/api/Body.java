package ase.battleship.api;

import ase.battleship.util.Util;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates the body of the message
 * @author tharindu
 */
public class Body {
    private byte[] byteArray;

    private String bodyString;
    private short bodyLength;
    /**
     * Sets the string containing the message body to be sent.
     * @param bodyString the string containing the message body.
     */
    public void setBodyString(String bodyString) {
        this.bodyString = bodyString;
    }

    /**
     * Returns the message body string.
     * @return the message body
     */
    public String getBodyString() {
        return bodyString;
    }
    /**
     * Returns a byte array containing the body using default encoding.
     * @return byte array of body
     * @throws UnsupportedEncodingException
     */
    public byte[] toByteArray() throws UnsupportedEncodingException {
        byteArray = bodyString.getBytes(Util.DEFAULT_ENCODING);
        return byteArray;
    }

    /**
     * Returns a byte array containing the body using specified encoding.
     * @param encoding encoding type of body
     * @return byte array of body
     * @throws UnsupportedEncodingException
     */
    public byte[] toByteArray(String encoding) throws UnsupportedEncodingException {
        byteArray = bodyString.getBytes(encoding);
        return byteArray;
    }
    /**
     * Returns the length of the body string message.
     * @return short value of length of the body
     */
    public short getBodyLength() {
        try {
            bodyLength = (short) (bodyString.getBytes(Util.DEFAULT_ENCODING).length);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Body.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bodyLength;
    }
}
