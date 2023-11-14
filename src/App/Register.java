package App;

import java.util.ArrayList;
import java.util.Scanner;

import User.*;
import Payment.*;

import javax.xml.crypto.Data;
import java.util.Random;


public class Register {
    private ArrayList<User> listOfRegisteredUser;
    public OTPConfirmation otp;

    public Register(Database database) {
        this.listOfRegisteredUser = database.getListofUser();
        this.otp = new OTPConfirmation();
    }

    public Boolean verifyRegister() {

        //Username Check
        System.out.println("Enter your username");
        Scanner in = new Scanner(System.in);
        String user = in.nextLine();
        in.nextLine();
        boolean isTaken = false;
        do {
            for (int i = 0; i < listOfRegisteredUser.size(); i++) {
                if (listOfRegisteredUser.get(i).getUsername().equals(user)) {
                    System.out.println("The username you entered is already taken, Try Again");
                    isTaken = true;
                    user = in.nextLine();
                    in.nextLine();
                }
            }
        } while (isTaken);
        System.out.println("Username is added successfully");


        //Password Check
        System.out.println("Enter your passsword");
        String pass = in.nextLine();
        in.nextLine();
        boolean isValid = true;
        do {
            isValid = isPasswordValid(pass);
            if (!isValid) {
                pass = in.nextLine();
                in.nextLine();
            }
        } while (!isValid);
        System.out.println("Password is added successfully");


        //Phone Check
        System.out.println("Enter your phone number");
        String phone;
        do {
            phone = in.nextLine();
            in.nextLine();

            isValid = isPhoneValid(phone);
            if (!isValid)
                System.out.println("Invalid phone number, Try Again!");

        } while (!isValid);
        System.out.println("Phone number is added successfully");
        int phoneNumber = Integer.parseInt(phone);


        //PIN Check
        boolean isPinValid =true;
        System.out.println("Enter your PIN");
        String PIN;
        do {
            isPinValid = true;
            PIN = in.nextLine();
            //in.nextLine();

            if (PIN.length() != 4) {
                isPinValid = false;
                System.out.println("Your PIN must have 4 digits");
            }
        } while (!isPinValid);
        System.out.println("Your PIN is added successfully!");
        int pin = Integer.parseInt(PIN);


        //Account Type Check
        System.out.println("Choose your account type\n1-Bank Account\n2-Wallet Account");
        int choose = in.nextInt();
        in.nextLine();

        if (choose == 1) {
            BankUser bankUser = new BankUser(user, pass, phoneNumber, pin, "Bank");
            BankUser updatedBankUser=validateBankUser(bankUser);

            listOfRegisteredUser.add(updatedBankUser);
            //database.addUser(updatedBankUser);
            in.close();

        } else if (choose == 2) {
            WalletUser walletUser = new WalletUser(user, pass, phoneNumber, pin, "Wallet");
            validateWalletUser(walletUser);
        }


        return false;
    }

    private static boolean isPasswordValid(String password) {
        // Password requirements: At least 8 characters, with at least one uppercase, one lowercase,
        // one digit, and one special character

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";

        if (password.length() < 8) {
            System.out.println("Password should be at least 8 characters long.");
            return false;
        }

        if (!password.matches(regex)) {
            System.out.println("Password should contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
            return false;
        }

        return true;
    }

    public boolean isPhoneValid(String phone) {
        String regex = "^(010|011|012|015)\\d{8}$";

        if (phone.matches(regex))
            return true;
        else
            return false;
    }

    public BankUser validateBankUser(BankUser user) {
        Scanner in=new Scanner(System.in);
        //Check Bank Name
        System.out.println("Choose which bank is your:\n1-NBE\n2-QNB\n3-CIB");
        boolean isValid = true;
        do {
            isValid = true;
            in = new Scanner(System.in);
            int choose = in.nextInt();
            in.nextLine();


            if (choose == 1)
                user.bank.setBankName("NBE");
            else if (choose == 2)
                user.bank.setBankName("QNB");
            else if (choose == 3)
                user.bank.setBankName("CIB");
            else {
                System.out.println("Invalid input,Try Again!");
                isValid = false;
            }
        } while (!isValid);

        //CardNum Check
        String cardNum;
        System.out.println("Enter your card number");
        Boolean isCardNumValid = true;
        do {
            isCardNumValid=true;

            cardNum = in.nextLine();
            in.nextLine();

            String cardNumRegex = "^\\d{16}$";

            if (!cardNum.matches(cardNumRegex)) {
                isCardNumValid = false;
                System.out.println("Wrong input, Try Again!");
            }
        } while (!isCardNumValid);

        //Expiry Date Check
        System.out.println("Enter your card's expiry date ex:MM/YY 'add the slash'");
        boolean isDateValid = true;
        do {
            isDateValid = true;
            String expiryDate = in.nextLine();
            in.nextLine();
            String expiryDateRegex = "^(0[1-9]|1[0-2])/\\d{2}$";

            if (!expiryDate.matches(expiryDateRegex)) {
                isDateValid = false;
                System.out.println("Wrong input, Try Again!");
            }
        } while (!isDateValid);

        //Account Number Check
        System.out.println("Enter your bank account number (it must be 10 numbers):");
        boolean isAccountNumValid = true;

        do {
            String accountNum = in.nextLine();
            in.nextLine();

            String bankAccountRegex = "^\\d{10}$";

            if (!accountNum.matches(bankAccountRegex)) {
                isAccountNumValid = false;
                System.out.println("Wrong input, Try Again!");
            } else {
                isAccountNumValid = true;
            }
        } while (!isAccountNumValid);
        System.out.println("Your card is added successfully!");

        //Balance Check
        //generates random user balance between 10000 and 20000
        Random random = new Random();
        float randomBalance = 10000 + random.nextFloat() * (20000 - 10000);
        user.bank.setBalance(randomBalance);

        validateOTP();
        in.nextLine();
        in.close();

        System.out.println("Your InstaPay account is created successfully!");
        return user;
    }


    public void validateWalletUser(WalletUser user) {
    }

    public boolean validateOTP() {
        boolean isValid = true;
        String inputOTP;
        String OTP = otp.OTPGenerator();
        System.out.println("Your OTP to register is " + OTP);
        do {
            System.out.println("Enter your OTP");
            Scanner in = new Scanner(System.in);
            inputOTP = in.nextLine();
            in.nextLine();
            if (inputOTP.equals(OTP))
                return true;
            else {
                isValid=false;
                System.out.println("Wrong OTP, Try Again!");
            }
        }while (!isValid);
        return false;
    }






public static void main(String[] args) {
        Database database=new Database();
        Register register=new Register(database);
        Register register1=new Register(database);

        register.verifyRegister();
        database.printUsers();

        register1.verifyRegister();
        database.printUsers();


    }


}
