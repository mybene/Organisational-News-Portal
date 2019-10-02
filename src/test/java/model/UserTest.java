package model;

import models.News;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
User user;

    @Before
    public void initial() {
        User user = new User("Bene","teamLeader","logistic",120);
    }

    @Test
    public void User_instiateCorrectly() {
        assertEquals(true, user instanceof User);
    }

    @Test
    public void getName_theTitleisGivenCorrectly_string() {
        assertEquals("BENE", user.getName());
    }


    @Test
    public void position_isStatedCorrectly_string() {
        assertEquals("teamLeader", user.getPosition());
    }
    @Test
    public void department_teambelongs_string() {
        assertEquals("logistic", user.getDept());
    }

    @Test
    public void badgeId_isStatedCorrectly_int() {
        assertEquals(30, user.getBadgeId());
    }

    @Test
    public void equals_returnTrueIfPropertiesAreSame_true() {
        User user1 = new User("Bene", "teamLeader", "logistic", 120);
        assertEquals(user1, user.equals(user1));
    }


    @Test
    public void saveTheNewsInDatabase() {
        user.save();
        assertEquals(true,News.all().equals(user));
    }

    @Test
    public void all_returnAllInstancesOfUser_true(){
        user.save();
        User user1 = new User("Bily", "officer", "logistic", 130);
        user1.save();
        User user2 = new User("JP", "CEO", "Administration", 100);
        user2.save();
        assertEquals(true,User.all().get(0).equals(user1));
        assertEquals(true,User.all().get(1).equals(user2));
    }

    @Test
    public void deleteById() {
        user.save();
        user.delete();
        assertEquals(0, user);
    }
}

