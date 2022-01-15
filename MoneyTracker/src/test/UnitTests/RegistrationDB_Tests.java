package UnitTests;

import controller.UserController;
import database.DatabasePersons;
import database.PersonsDB;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class RegistrationDB_Tests {

    public RegistrationDB_Tests(){}

    @Before
    public void initialize(){}

    @Mock
    private final DatabasePersons personsDB = PersonsDB.getInstance();
    @Mock
    private final UserController userController = new UserController(personsDB);

    @Test
    public void CreateUser()
    {
        User user = new User("Test","Test","10/02/1999","M","LalaStraat 10",0.0);
        userController.addUser(user);
        Assert.assertEquals(userController.getAllUsersSortedById().get(0).getName(),"Test");
    }

    @Test
    public void DeleteUser(){
        System.out.println("BEFORE DELETION : "  + userController.getAllUsersSortedById());
        userController.deleteUserById(0);
        System.out.println("AFTER DELETION : " + userController.getAllUsersSortedById());
        int dbSize = userController.getAllUsersSortedById().size();
        Assert.assertEquals(dbSize,0);
    }

}
