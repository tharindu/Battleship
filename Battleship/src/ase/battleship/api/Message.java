package ase.battleship.api;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang.ArrayUtils;

/**
 * Base class of messages to be sent to the client
 * @author tharindu
 */
public class Message {
    public static byte INITIATE = 0;
    public static byte ACCEPT = 1;
    public static byte REJECT = 2;
    public static byte SALVO = 3;
    public static byte SALVO_RESPONSE = 4;
    protected Header header;
    protected Body body;
    /**
     * Sets the header of the message
     * @param header <code>Header</code> object
     */
    public void setHeader(Header header) {
        this.header = header;
    }
    /**
     * Sets the body of the message
     * @param body <code>Body</code> object
     */
    public void setBody(Body body) {
        this.body = body;
    }
    /**
     * Gets the header of the message
     * @return <code>Header</code> object
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Gets the body of the message
     * @return <code>Body</code> object
     */
    public Body getBody() {
        return body;
    }

    public byte[] toByteArray() throws UnsupportedEncodingException {
        byte[] byteArray = ArrayUtils.addAll(header.toByteArray(), body.toByteArray());
        return byteArray;
    }

}
