package test_database.test_entities;
import server.entities.ChatProfile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestGroupProfile {

//    @Test
//    public void testGetUID(){
//        int newId = 333146;
//        ChatProfile profile = new ChatProfile("name", "description");
//        Assertions.assertEquals(newId, profile.getUID(), "Incorrect UID returned");
//    }

    @Test
    public void testGetName(){
        String name = "name";
        ChatProfile profile = new ChatProfile(name, "description");
        Assertions.assertEquals(name, profile.getName(), "Incorrect Name returned");
    }

    @Test
    public void testGetDescription(){
        String bio = "description";
        ChatProfile profile = new ChatProfile("name", bio);
        Assertions.assertEquals(bio, profile.getDescription(), "Incorrect Description Returned");
    }
//todo change this test

//    @Test
//    public void testGetProfilePicture(){
//        ProfilePicture pic = new ProfilePicture();
//        GroupProfile profile = new GroupProfile(333146, "name", "bio", pic);
//        Assertions.assertEquals(pic, profile.getProfilePicture(), "Incorrect ProfilePicture Returned");
//    }

    @Test
    public void testSetName(){
        String new_name = "another name";
        ChatProfile profile = new ChatProfile( "name", "bio");
        profile.setName(new_name);
        Assertions.assertEquals(new_name, profile.getName(), "Name was not changed");
    }
    @Test
    public void testSetDescription() {
        String new_bio = "another name";
        ChatProfile profile = new ChatProfile("name", "bio");
        profile.setDescription(new_bio);
        Assertions.assertEquals(new_bio, profile.getDescription(), "Description was not changed");
    }
//todo change this test

//    @Test
//    public void testSetProfilePicture(){
//        ProfilePicture pic = new ProfilePicture();
//        GroupProfile profile = new GroupProfile(333146, "name", "bio");
//        Assertions.assertNull(profile.getProfilePicture());
//        profile.setProfilePicture(pic);
//        Assertions.assertEquals(pic, profile.getProfilePicture(), "ProfilePic was not Changed");
//    }
}
