package client.frameworks_and_drivers.communication_manager;

public interface ClientComConstants
{
    public int PACKET_LEN = 256;

    char SPR = 31;
    public String SEPARATOR = String.valueOf(SPR); //Character.toString(6);

    public int SLICE_PACKET = 0;
    public int SLICE_ACK = 1;

    public int SEND_INTERVAL = 100*5*1000;
    public int SEND_TIMEOUT = 60*60*1000;
    public int REFRESH_INTERVAL = 10*60*1000;

    public int SENDER_WAITTIME = 100;

    public int MAX_RESEND_TIMES = 3;


}