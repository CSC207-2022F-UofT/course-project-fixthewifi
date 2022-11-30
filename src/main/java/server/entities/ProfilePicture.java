package server.entities;

public class ProfilePicture
{

//todo how it should look like

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    byte[] imageBytes;

    public ProfilePicture(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

}
