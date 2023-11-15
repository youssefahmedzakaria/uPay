package App;

import java.util.ArrayList;
import User.*;
import Payment.*;

public class Database {
    private static ArrayList<User> listofUser;
    private static ArrayList<BankUser> listOfBankUser;
    private static ArrayList<WalletUser>listOfWalletUser;

    public Database(){
        this.listofUser=new ArrayList();
        this.listOfBankUser = new ArrayList();
        this.listOfWalletUser = new ArrayList();

        for (User regUser : listofUser) {
            if (regUser instanceof BankUser) {
                BankUser bankUser = (BankUser) regUser;
                listOfBankUser.add(bankUser);
            } else if (regUser instanceof WalletUser) {
                WalletUser walletUser = (WalletUser) regUser;
                listOfWalletUser.add(walletUser);
            }
        }
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
    public ArrayList<BankUser> getListofBankUser(){
        return this.listOfBankUser;
    }
    public ArrayList<WalletUser> getListofWalletUser(){
        return this.listOfWalletUser;
    }



    public User getUser(String username){
        for (User user :listofUser){
            if (user.getUsername().equals(username))
                return user;
        }
        System.out.println("User is not found");
        return null;
    }
    public void printUsers(){
        for (User user : listofUser){
            System.out.println(user.getUsername() +" , " + user.getAccountType()+" Account");
        }
    }
}
