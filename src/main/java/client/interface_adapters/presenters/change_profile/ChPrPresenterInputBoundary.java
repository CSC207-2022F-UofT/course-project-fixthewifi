package client.interface_adapters.presenters.change_profile;

public interface ChPrPresenterInputBoundary
{
    void setPic(String url);
    void delPic();
    void updateName(String newname);
    void updateDescr(String newdesc);
}
