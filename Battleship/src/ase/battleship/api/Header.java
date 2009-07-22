package ase.battleship.api;

/**
 * Creates a header object to be added to the message.
 * <p>Header contains fixed length 16 bytes. It consists of API Version, API Format, Message Type, Reserved Byte,
 * Source ID, Destination ID, Message Length, few other reserved bytes and Checksum.</p>
 * @author tharindu
 */
public class Header {

    private byte byteArray[];

    private byte apiVersion;
    private byte apiFormat;
    private byte messageType;
    private byte reservedByte;
    private short sourceId;
    private short destinationId;
    private short bodyLength;
    private short reservedTwoByte;
    private byte[] reservedThreeByte;
    private byte checksum;

    /**
     * Constructs the header without any data.
     */
    public Header() {
        byteArray = new byte[16];
        reservedThreeByte = new byte[3];
    }
    /**
     * Constructs the header with API version, API format, Message Type, Source ID,
     * Destination ID and bodyLength.
     */
    public Header(byte apiVersion, byte apiFormat, byte messageType,
            short sourceId, short destinationId) {
        byteArray = new byte[16];
        this.apiVersion = apiVersion;
        this.apiFormat = apiFormat;
        this.messageType = messageType;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
    }
    /**
     * Sets the length of the message body.
     * @param bodyLength short value specifying body length
     */
    public void setBodyLength(short bodyLength) {
        this.bodyLength = bodyLength;
    }

    /**
     * Returns the header details as a byte array.
     * @return byte array with header data
     */
    public byte[] toByteArray() {
        byteArray[0] = apiVersion;
        byteArray[1] = apiFormat;
        byteArray[2] = messageType;
        byteArray[3] = reservedByte;
        // adding short values to array
        byteArray[4] = (byte) ( (sourceId >> 8) & 0xff );
        byteArray[5] = (byte) ( sourceId & 0xff);
        byteArray[6] = (byte) ( (destinationId >> 8) & 0xff );
        byteArray[7] = (byte) ( destinationId & 0xff);
        byteArray[8] = (byte) ( (bodyLength >> 8) & 0xff );
        byteArray[9] = (byte) ( bodyLength & 0xff);
        // Tempory data
        byteArray[10] = 0;
        byteArray[11] = 0;
        byteArray[12] = 0;
        byteArray[13] = 0;
        byteArray[14] = 0;
        byteArray[15] = 0;
        /**
        byteArray[10] = (byte) ( (reservedTwoByte >> 8) & 0xff );
        byteArray[11] = (byte) ( reservedTwoByte & 0xff);
        byteArray[12] = reservedThreeByte[0];
        byteArray[13] = reservedThreeByte[1];
        byteArray[14] = reservedThreeByte[2];
        byteArray[15] = checksum;**/
        return byteArray;
    }
}
