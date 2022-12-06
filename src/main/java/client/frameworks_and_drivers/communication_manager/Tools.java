package client.frameworks_and_drivers.communication_manager;

import java.util.Random;

public class Tools
{

    public static byte[] getBytes(byte[] byteArr,int loc, int len)
    {

        byte[] retByteArr = null;

        if(len > 0 && loc >= 0 && byteArr.length >= loc + len)
        {
            retByteArr = new byte[len];

            System.arraycopy(byteArr, loc, retByteArr, 0, len);
        }

        return retByteArr;
    }

    public static int divideUp(int numerator, int denominator)
    {
        int residual;
        int quotient = 0;

        if(denominator != 0)
        {
            quotient = numerator / denominator;
            residual = numerator % denominator;

            if(residual != 0) quotient++;

        }

        return quotient;
    }


    public static int id = 0;
    public static int generateID()
    {
        Random random = new Random();
        return random.nextInt(1000000);
    }
}
