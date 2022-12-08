package testFriend;

import org.junit.Test;

public class TestAcceptFriend {
    @Test
    public void testAccept(){
        //register two new users

        //send request from a to b, entering uid

        //b accept the request

        //test if friend uid is added to the database: userfile[6] in each two users
        //assert not empty

        //assert empty: userfile[9] in each two users

    }

    @Test
    public void testReject(){
        //register two new users

        //send request from a to b, but entering wrong uid

        //assert empty: userfile[9] in each two users

        //assert empty: userfile[6] in each two users

    }
}
