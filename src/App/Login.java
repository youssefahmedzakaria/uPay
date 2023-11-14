package App;

import User.User;

import java.util.ArrayList;

public class Login {
    private ArrayList<User> listOfUsers;

    public Login(ArrayList<User> l) {
        this.listOfUsers = l;
    }

    public Boolean verifyLogin(String user, String pass) {
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (listOfUsers.get(i).getUsername().equals(user) && listOfUsers.get(i).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

}
