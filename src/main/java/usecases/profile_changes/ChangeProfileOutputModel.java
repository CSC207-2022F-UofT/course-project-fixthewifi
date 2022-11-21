package usecases.profile_changes;

import entities.ProfilePicture;
/**
 * This class is a data structure of out data for Changing Profile usecase.
 *
 */
public class ChangeProfileOutputModel {
    private final String useraddress;
    private final int userport;
    private final int profileUID;

    private final String changeStatusMessage;
//    private String name;
//    private String description;
//    private ProfilePicture pic;
//    public ChangeProfileOutputModel(int profileUID, String name, String description,ProfilePicture pic) {
//        this.profileUID = profileUID;
//        this.pic = pic;
//        this.name = name;
//        this.description = description;
//    }

    public ChangeProfileOutputModel(String useraddress, int userport, int profileUID, String changeStatusMessage) {

        this.useraddress= useraddress;
        this.userport=userport;
        this.profileUID = profileUID;
        this.changeStatusMessage=changeStatusMessage;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public int getUserport() {
        return userport;
    }

    public int getProfileUID() {
        return profileUID;
    }

    public String getChangeStatusMessage() {
        return changeStatusMessage;
    }
    //
//    public ProfilePicture getPic() {
//        return pic;
//    }
//
//    public void setPic(ProfilePicture pic) {
//        this.pic = pic;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }

}


