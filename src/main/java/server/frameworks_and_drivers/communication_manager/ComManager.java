package server.frameworks_and_drivers.communication_manager;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ComManager implements IfComManager
{
    int port;
    ComManagerUser user;
    public static DatagramSocket socket;

    private final boolean debug;

    public ComManager(boolean debug)
    {
        this.debug = debug;
    }

    /**
     * This method starts comManager.
     @param port The port for receiving messages.
     @param  user The user of comManager (i.e. inputSorter).
     */
    public void init(int port, ComManagerUser user)
    {
        try
        {
            //socket to receive data packet
            socket = new DatagramSocket(port);
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }


        this.port = port;
        this.user = user;
        Receiver receiver = new Receiver(user, debug);
        receiver.start();
    }

    /**
     * This method sends a String to the designated address over the internet.
     @param msg The message to be sent, in String format.
     @param peerIP The destination ip.
     @param peerPort The destination port.
     */
    @Override
    public void send(String peerIP, int peerPort, String msg) {
        InetAddress peerAddr = null;
        try {
            peerAddr = InetAddress.getByName(peerIP);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int sliceLen = 0;
        byte[] data = msg.getBytes(StandardCharsets.UTF_8);
        int totalSlices = (int) Math.ceil((double) data.length / ServerComConstants.PACKET_LEN);
        String msgId = String.valueOf(Tools.generateID());

        for(int j=0; j<totalSlices; j++)
        {
            if(j+1<totalSlices)
            {
                //  setting slice length to 128
                sliceLen = ServerComConstants.PACKET_LEN;
            }
            else
            {
                //  packet data length for the remaining portion
                sliceLen = data.length - (j)* ServerComConstants.PACKET_LEN;
            }

            byte[] a = Tools.getBytes(data, j* ServerComConstants.PACKET_LEN, sliceLen);

            String toByte  = ServerComConstants.SEPARATOR + ServerComConstants.SLICE_PACKET + ServerComConstants.SEPARATOR + msgId + ServerComConstants.SEPARATOR + totalSlices + ServerComConstants.SEPARATOR+ j + ServerComConstants.SEPARATOR;

            byte[] b = toByte.getBytes(StandardCharsets.UTF_8);

            byte[] c = new byte[a.length + b.length];
            System.arraycopy(a, 0, c, 0, a.length);
            System.arraycopy(b, 0, c, a.length, b.length);

            DatagramPacket packet = new DatagramPacket(c,0,c.length, peerAddr, peerPort);
            try {
                socket.send(packet);
                if (debug)
                {
                    System.out.println("Server comManager - Sent Message: " + msg);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
