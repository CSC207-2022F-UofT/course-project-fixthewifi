package server.interface_adapters.friend;

import java.util.List;

import server.frameworks_and_drivers.communication_manager.IfComManager;


public class ViewFriendOutputAdapater
{
    private final IfComManager comManager;
    public ViewFriendOutputAdapater(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    /**
     * divide list in to a list of name and a list of int and send them to comManager instead of HashMap
     * @param list
     * @param address
     * @param peerPort
     */
    public void pushFriendList(ArrayList<HashMap<String, Integer>> list, String address, int peerPort)
    {
        ArrayList<String> namelist = new ArrayList<>();
        ArrayList<Integer> idlist = new ArrayList<>();
        for (HashMap<String, Integer> map : list){
            for (String key : map.keySet()){
                namelist.add(key);
                idlist.add(map.get(key));
            }
        }
        String content_names = namelist.toString();
        String content_ids = idlist.toString();
        comManager.send(address, peerPort, content_names);
        comManager.send(address, peerPort, content_ids);
    }
}
