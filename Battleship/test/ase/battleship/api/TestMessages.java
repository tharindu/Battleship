package ase.battleship.api;

import ase.battleship.util.Util;
import junit.framework.TestCase;
import ase.battleship.client.ApiClient;
import java.io.IOException;
import java.util.Vector;

public class TestMessages extends TestCase{
     ApiClient apiClient;
     protected void setUp() {
          apiClient = new ApiClient(Util.TEST_API_HOST, Util.TEST_API_PORT);
     }

     protected void tearDown() {
          apiClient = null;
     }
     public void testInitGameMessage() throws IOException {
         Header header = new Header((byte)1,(byte)1,Message.INITIATE,(short)64031,(short)98);
         Body body = new Body();
         body.setBodyString(Messages.getInitGameRequest("001"));
         header.setBodyLength(body.getBodyLength());
         Message message = new Message();
         message.setBody(body);
         message.setHeader(header);
         apiClient.sendMsgOnly(message.toByteArray());
         assertEquals(Messages.getInitGameRequest("001"), "[GID=001]");
     }
     public void testAcceptResponse() throws IOException {
         Header header = new Header((byte)1,(byte)1,Message.ACCEPT,(short)64031,(short)98);
         Body body = new Body();
         body.setBodyString(Messages.getServerReadyResponse("002"));
         header.setBodyLength(body.getBodyLength());
         Message message = new Message();
         message.setBody(body);
         message.setHeader(header);
         apiClient.sendMsgOnly(message.toByteArray());
         assertEquals(Messages.getServerReadyResponse("002"), "[GID=002]");
     }
     public void testRejectResponse() throws IOException {
         Header header = new Header((byte)1,(byte)1,Message.REJECT,(short)64031,(short)98);
         Body body = new Body();
         body.setBodyString(Messages.getServerRejectResponse("003",05));
         header.setBodyLength(body.getBodyLength());
         Message message = new Message();
         message.setBody(body);
         message.setHeader(header);
         apiClient.sendMsgOnly(message.toByteArray());
         assertEquals(Messages.getServerRejectResponse("003",5), "[GID=003,RC=5]");
     }
     public void testFireSalvoRequest() throws IOException {
         Header header = new Header((byte)1,(byte)1,Message.SALVO,(short)64031,(short)98);
         Body body = new Body();
         body.setBodyString(Messages.getFireSalvoRequest("004", 0, 3, "A1", "C8", "E3"));
         header.setBodyLength(body.getBodyLength());
         Message message = new Message();
         message.setBody(body);
         message.setHeader(header);
         apiClient.sendMsgOnly(message.toByteArray());
         assertEquals(Messages.getFireSalvoRequest("004", 0, 3, "A1", "C8", "E3"),
                 "[GID=004,SID=0,NOT=3,T1=A1,T2=C8,T3=E3]");
     }
     public void testFireSalvoResponse() throws IOException {
         Header header = new Header((byte)1,(byte)1,Message.SALVO_RESPONSE,(short)64031,(short)98);
         Body body = new Body();
         Vector sunkShipIds = new Vector();
         sunkShipIds.add("01");
         sunkShipIds.add("03");
         body.setBodyString(Messages.getFireSalvoResponse("005", 0, 0, 3, 2, sunkShipIds));
         header.setBodyLength(body.getBodyLength());
         Message message = new Message();
         message.setBody(body);
         message.setHeader(header);
         apiClient.sendMsgOnly(message.toByteArray());
         assertEquals(Messages.getFireSalvoResponse("005", 0, 0, 3, 2, sunkShipIds),
                 "[GID=005,SID=0,SAS=0,NOH=3,NSS=2,[SS0=01,SS1=03]]");
     }
}
