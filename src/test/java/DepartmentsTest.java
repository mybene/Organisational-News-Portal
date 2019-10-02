
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentsTest {

    Departments departments;
    @Before
    public void initial() {
        Departments departments = new  Departments(1,"Production","delivey on time",30);
    }

    @Test
    public void Department_instatiatedCorrectly() {
        assertEquals(true, departments instanceof Departments);
    }

    @Test
    public void dname_theTitleisGivenCorrectly_string() {
        assertEquals("production", departments.getDname());
    }


    @Test
    public void slogon_isStatedCorrectly_string() {
        assertEquals("time delivery", departments.getSlogon());
    }
    @Test
    public void members_teamComposeBy_int() {
        assertEquals("time delivery", departments.getMembers());
    }

    @Test
    public void Id_deptIsIdentified_int() {
        assertEquals(30, departments.getId());
    }

    @Test
    public void equals_returnTrueIfPropertiesAreSame_true() {
        User departments1 = new User("Bene", "teamLeader", "logistic", 120);
        assertEquals(departments1, departments.equals(departments1));
    }


    @Test
    public void saveTheNewsInDatabase() {
        departments.save();
        assertEquals(true, News.all().equals(departments));
    }

    @Test
    public void all_returnAllInstancesOfUser_true(){
        departments.save();
        User departments1 = new User("Bily", "officer", "logistic", 130);
        departments1.save();
        User departments2 = new User("JP", "CEO", "Administration", 100);
        departments2.save();
        assertEquals(true,User.all().get(0).equals(departments1));
        assertEquals(true,User.all().get(1).equals(departments2));
    }

    @Test
    public void deleteById() {
        departments.save();
        departments.delete();
        assertEquals(0, departments);
    }
}


