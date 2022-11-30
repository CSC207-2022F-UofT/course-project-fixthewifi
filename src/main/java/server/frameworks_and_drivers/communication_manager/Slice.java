package server.frameworks_and_drivers.communication_manager;

public class Slice
{
    public int msgId;
    public int port;
    public String ip  = "";
    public int totalSlices;
    int count;	//used for counting how many slices currently received by the matrix sublist
    public int sliceIndex;
    public String sliceData;

    public String toString()
    {
        return sliceIndex + "---" + totalSlices;
    }


}
