package view.GuiHandler;

import controller.UserController;
import database.PersonsDB;
import model.User;

public class RegistrationLeftPanelHandler {

    PersonsDB personsDB = PersonsDB.getInstance();
    UserController userController = new UserController(personsDB);

    public void createUserListener(User user){
        userController.addUser(user);
    }

    public void deleteUserListener(Integer s){
        userController.deleteUserById(s);
    }

    public String addElementUserlistListener(){
        String name = userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getName().toString();
        String surname = userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getSurname().toString();
        return  name + " " + surname;
    }

}
