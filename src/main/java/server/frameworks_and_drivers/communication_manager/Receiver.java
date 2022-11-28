package server.frameworks_and_drivers.communication_manager;

import java.io.IOException;
import java.net.DatagramPacket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Receiver extends Thread
{

    HashMap<Integer, ArrayList<Slice>> sliceMatrix;
    int count = 0;
    ComManagerUser user;

    public Receiver(ComManagerUser user)
    {
        this.user = user;
        sliceMatrix = new HashMap<Integer, ArrayList<Slice>>();
    }

    public void run()
    {
        Slice slice;
        String dataStr;

        int type;
        int port;
        String ip;
        String msgId;
        int totalSlices;
        int sliceIndex;
        String sliceData;
        int sep;

        while (true)
        {
            try
            {
                byte[] buffer =new byte[Constants.PACKET_LEN*2];
                DatagramPacket slicePacket  = new DatagramPacket(buffer,0,buffer.length);

                //receive packet
                comManager.socket.receive(slicePacket);
                port = slicePacket.getPort();
                ip = slicePacket.getAddress().getHostAddress();
                dataStr = new String(slicePacket.getData(), StandardCharsets.UTF_8);
                String[] str = dataStr.split(Constants.SEPARATOR);
//                System.out.println(Arrays.toString(str));
                if (Integer.parseInt(str[1]) == Constants.SLICE_ACK)
                {
//                    handleAck(str, ip, port);
                }
                else
                {
                    handleSlice(str, ip, port);
                    count ++;

                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    public void handleAck(String dataStr, String ip, int port)
    {
//        SlicePacket packet;
//
//        int sep1 = dataStr.indexOf(UDPConstants.SEPARATOR);
//        int sep2 = dataStr.indexOf(UDPConstants.SEPARATOR, sep1+1);
//
//        SliceAck ack = new SliceAck();
//        ack.ip  = ip;
//        ack.port =  port;
//        ack.msgId = Integer.valueOf(dataStr.substring(0, sep1));
//        ack.sliceIndex = Integer.valueOf(dataStr.substring(sep1+1, sep2));
//
//        synchronized(slicePacketList)
//        {
////			int index = 0;
////			while (index < slicePacketList.size())
////			{
////				packet = slicePacketList.get(index);
////				if (ack.ip.equals(packet.ip) && ack.port == packet.port && ack.msgId == packet.msgId && ack.sliceIndex == packet.sliceIndex)
////				{
////					slicePacketList.remove(index);
////					System.out.println("removed slice uid: " + packet.sliceIndex );
////				}
////				else
////				{
////					index++;
////				}
////			}
//        }
    }

    public void handleSlice(String[] strArr, String ip, int port)
    {
//        System.out.println(Arrays.toString(strArr));
        Slice slice = new Slice();
        slice.ip = ip;
        slice.port = port;
        slice.sliceData = strArr[0];
        slice.msgId = Integer.parseInt(strArr[2]);
        slice.totalSlices = Integer.parseInt(strArr[3]);
        slice.sliceIndex = Integer.parseInt(strArr[4]);

        synchronized(sliceMatrix)
        {
            if (sliceMatrix.containsKey(slice.msgId))
            {
//                System.out.println(1);
                ArrayList<Slice> msgList = sliceMatrix.get(slice.msgId);
                msgList.add(slice);
                if (msgList.size() == slice.totalSlices)
                {
                    msgList.sort(new Comparator<Slice>()
                    {
                        @Override
                        public int compare(Slice o1, Slice o2) {
                            return Integer.compare(o1.sliceIndex, o2.sliceIndex);
                        }
                    });

                    StringBuilder builder = new StringBuilder();
                    for (Slice object: msgList)
                    {
                        builder.append(object.sliceData);
                    }
                    System.out.println("comManager: " + builder);
                    user.onMsg(builder.toString(), slice.ip);
                    sliceMatrix.remove(slice.msgId);
                }
            }
            else
            {
//                System.out.println(2);
                ArrayList<Slice> list = new ArrayList<>();
                list.add(slice);
                sliceMatrix.put(slice.msgId, list);

                if (list.size() == slice.totalSlices)
                {
                    System.out.println("comManager: " + slice.sliceData);

                    user.onMsg(slice.sliceData, slice.ip);
                }
                System.out.println(sliceMatrix);
            }
        }

//		SliceAck sliceAck = new SliceAck();
//
//		sliceAck.ip = ip;
//		sliceAck.port = port;
//		sliceAck.msgId = Integer.valueOf(slice.msgId);
//		sliceAck.sliceIndex = slice.sliceIndex;
//
//		String strAck = UDPConstants.SLICE_ACK + UDPConstants.SEPARATOR +
//				sliceAck.msgId + UDPConstants.SEPARATOR + sliceAck.sliceIndex + UDPConstants.SEPARATOR;
//
//		byte[] data = strAck.getBytes(StandardCharsets.UTF_8);
//
//		DatagramPacket ack;
//		try
//		{
//			ack = new DatagramPacket(data,0,data.length, InetAddress.getByName(ip) , port);
//
//			UDP.socket.send(ack);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
    }
}