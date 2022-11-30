package client.frameworks_and_drivers.communication_manager;

public class Slice
{
    int msgId;
    int port;
    String ip  = "";
    int totalSlices;
    int count;	//used for counting how many slices currently received by the matrix sublist
    int sliceIndex;
    String sliceData;

    public String toString()
    {
        return sliceIndex + "---" + totalSlices;
    }


}
