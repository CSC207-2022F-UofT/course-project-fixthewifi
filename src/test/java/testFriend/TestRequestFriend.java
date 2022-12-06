package testFriend;

import org.junit.Test;

public class TestRequestFriend {
    @Test
    public void testExecute(){
        //register two new users

        //send request from a to b, entering uid

        //test if request data is added to the database: userfile[9] in each two users
        //assert not empty
    }

    @Test
    public void testExecuteCaseFailure(){
        //register two new users

        //send request from a to b, but entering wrong uid

        //assert empty: userfile[9] in each two users
    }
}
