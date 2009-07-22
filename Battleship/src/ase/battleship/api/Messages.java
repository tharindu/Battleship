package ase.battleship.api;

import java.util.Vector;

/**
 * Class having Messages to be sent to client.
 * Hang for not having proper comments :)
 * @author tharindu
 */
public class Messages {
    protected static String getInitGameRequest(String gameId) {
        StringBuffer sb = new StringBuffer();
             sb.append("[GID=").
                append(gameId).
                append("]");
        return sb.toString();
    }
    protected static String getServerReadyResponse(String gameId) {
        StringBuffer sb = new StringBuffer();
             sb.append("[GID=").
                append(gameId).
                append("]");
        return sb.toString();
    }
    protected static String getServerRejectResponse(String gameId, int rejectCode) {
        StringBuffer sb = new StringBuffer();
             sb.append("[GID=").append(gameId).
                append(",").
                append("RC=").append(rejectCode).append("]");
        return sb.toString();
    }
    protected static String getFireSalvoRequest(String gameId, int sessionId,
            int noOfTargets, String t1, String t2, String t3) {
        StringBuffer sb = new StringBuffer();
             sb.append("[GID=").append(gameId).
                append(",").
                append("SID=").append(sessionId).
                append(",").
                append("NOT=").append(noOfTargets).
                append(",").
                append("T1=").append(t1).
                append(",").
                append("T2=").append(t2).
                append(",").
                append("T3=").append(t3).
                append("]");
        return sb.toString();
    }
    protected static String getFireSalvoResponse(String gameId, int sessionId,
            int sunkAllShips, int noOfHits, int noOfShipsSunk, Vector sunkShipIds) {
        StringBuffer sb = new StringBuffer();
             sb.append("[GID=").append(gameId).
                append(",").
                append("SID=").append(sessionId).
                append(",").
                append("SAS=").append(sunkAllShips).
                append(",").
                append("NOH=").append(noOfHits).
                append(",").
                append("NSS=").append(noOfShipsSunk).
                append(",[");
       for (int i = 0; i < sunkShipIds.size(); i++) {
             sb.append("SS").append(i).append("=").
                append((String)(sunkShipIds.elementAt(i)));
             if(i != sunkShipIds.size()-1)
             sb.append(",");
       }
             sb.append("]").
                append("]");
        return sb.toString();
    }

}
