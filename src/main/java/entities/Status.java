package entities;

public class Status
{
    private int status;

    public Status(int status)
    {
        if (status == StatusConstants.Offline || status == StatusConstants.Online)
        {
            this.status = status;
        }
        else
        {
            throw new IllegalArgumentException("There are only two status.");
        }
    }
    public int getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        if (status == StatusConstants.Offline)
        {
            return "Offline";
        }
        else
        {
            return "Online";
        }
    }
}


