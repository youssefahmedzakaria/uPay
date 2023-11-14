package App;

import java.util.ArrayList;
import User.*;
import Payment.*;

public class Database {
    private static ArrayList<User> listofUser;

    public Database(){
        this.listofUser=new ArrayList();
    }

    public void addUser(User user){
        this.listofUser.add(user);
    }

    public void setListofUser(ArrayList<User> l){
        this.listofUser=l;
    }

    public ArrayList<User> getListofUser(){
        return this.listofUser;
    }

    public void printUsers(){
        for (User user : listofUser){
            System.out.println(user.getUsername() +" , " + user.getAccountType()+" Account");
        }
    }
}
