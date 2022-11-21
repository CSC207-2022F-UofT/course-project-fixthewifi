package test_entities;
import entities.GroupProfile;
import entities.ProfilePicture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestGroupProfile {

    @Test
    public void testGetUID(){
        int newId = 333146;
        GroupProfile profile = new GroupProfile(newId, "name", "description");
        Assertions.assertEquals(newId, profile.getUID(), "Incorrect UID returned");
    }

    @Test
    public void testGetName(){
        String name = "name";
        GroupProfile profile = new GroupProfile(333146, name, "description");
        Assertions.assertEquals(name, profile.getName(), "Incorrect Name returned");
    }

    @Test
    public void testGetDescription(){
        String bio = "description";
        GroupProfile profile = new GroupProfile(333146, "name", bio);
        Assertions.assertEquals(bio, profile.getDescription(), "Incorrect Description Returned");
    }

    @Test
    public void testGetProfilePicture(){
        ProfilePicture pic = new ProfilePicture();
        GroupProfile profile = new GroupProfile(333146, "name", "bio", pic);
        Assertions.assertEquals(pic, profile.getProfilePicture(), "Incorrect ProfilePicture Returned");
    }

    @Test
    public void testSetName(){
        String new_name = "another name";
        GroupProfile profile = new GroupProfile(333146, "name", "bio");
        profile.setName(new_name);
        Assertions.assertEquals(new_name, profile.getName(), "Name was not changed");
    }
    @Test
    public void testSetDescription() {
        String new_bio = "another name";
        GroupProfile profile = new GroupProfile(333146, "name", "bio");
        profile.setDescription(new_bio);
        Assertions.assertEquals(new_bio, profile.getDescription(), "Description was not changed");
    }

    @Test
    public void testSetProfilePicture(){
        ProfilePicture pic = new ProfilePicture();
        GroupProfile profile = new GroupProfile(333146, "name", "bio");
        Assertions.assertNull(profile.getProfilePicture());
        profile.setProfilePicture(pic);
        Assertions.assertEquals(pic, profile.getProfilePicture(), "ProfilePic was not Changed");
    }
}
