package App;

import java.util.ArrayList;
import java.util.Scanner;

import User.*;
import Payment.*;

import javax.print.attribute.standard.JobName;
import javax.xml.crypto.Data;
import java.util.Random;


public class Register {
    private ArrayList<User> listOfRegisteredUser;
    private ArrayList<BankUser> listOfBankUser;
    private ArrayList<WalletUser>listOfWalletUser;
    public OTPConfirmation otp;

    public Register(Database database) {
        this.listOfRegisteredUser = database.getListofUser();
        this.listOfBankUser = database.getListofBankUser();
        this.listOfWalletUser = database.getListofWalletUser();

        this.otp = new OTPConfirmation();
    }

    public Boolean verifyRegister() {

        //Username Check
        System.out.println("Enter your username");
        Scanner in = new Scanner(System.in);
        String user = in.nextLine();
//        in.nextLine();
        boolean isTaken = false;
        do {
            isTaken=false;
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
        boolean isValid = true;
        do {
            isValid = isPasswordValid(pass);
            if (!isValid) {
                pass = in.nextLine();
            }
        } while (!isValid);
        System.out.println("Password is added successfully");


        //Phone Check
        boolean isPhoneValid;
        System.out.println("Enter your phone number");
        String phone;
        int phoneNumber = 0;

        do {
            isPhoneValid = true;
            phone = in.nextLine();

            try {
                phoneNumber = Integer.parseInt(phone);

                // Check if phone number matches regex
                if (!isPhoneValid(phone)) {
                    System.out.println("Invalid input, Try Again!");
                    isPhoneValid = false;
                } else {
                    // Check if phone number is already taken
                    for (User currentUser : listOfRegisteredUser) {
                        if (phoneNumber == currentUser.getPhoneNum()) {
                            System.out.println("The phone number you entered is already taken, Try again!");
                            isPhoneValid = false;
                            break; // No need to continue checking if found
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, Please enter a valid numeric phone number.");
                isPhoneValid = false;
            }

        } while (!isPhoneValid);

        System.out.println("Phone number is added successfully");


        // PIN Check
        boolean isPinValid = false;
        System.out.println("Enter your PIN");
        String PIN;

        do {
            isPinValid = true;
            PIN = in.nextLine();
            try {
                if (PIN.length() != 4 || !PIN.matches("\\d+")) {
                    isPinValid = false;
                    System.out.println("Your PIN must have 4 numeric digits");
                }
            } catch (NumberFormatException e) {
                isPinValid = false;
                System.out.println("Invalid input. Please enter a valid numeric PIN.");
            }
        } while (!isPinValid);

        System.out.println("Your PIN is added successfully!");
        int pin = Integer.parseInt(PIN);


        //Account Type Check
        System.out.println("Choose your account type\n1-Bank Account\n2-Wallet Account");
        boolean validInput = true;
        do {
            try {

                validInput = true;
                int choose = in.nextInt();
                in.nextLine();

                if (choose == 1) {
                    BankUser bankUser = new BankUser(user, pass, phoneNumber, pin, "Bank");
                    BankUser updatedBankUser = validateBankUser(bankUser);

                    listOfRegisteredUser.add(updatedBankUser);
                    listOfBankUser.add(updatedBankUser);
                    return true;

                } else if (choose == 2) {
                    WalletUser walletUser = new WalletUser(user, pass, phoneNumber, pin, "Wallet");
                    WalletUser updatedWalletUser = validateWalletUser(walletUser);

                    listOfRegisteredUser.add(updatedWalletUser);
                    listOfWalletUser.add(updatedWalletUser);
                    return true;
                } else {
                    System.out.println("Invalid input, Try Again!");
                    validInput = false;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.nextLine(); // Consume the invalid input
                validInput=false;
            }
        }while (!validInput);

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

        if (phone.matches(regex)) {
            return true;
        }
        else {
            return false;
        }
    }

    public BankUser validateBankUser(BankUser user) {
        Scanner in=new Scanner(System.in);
        //Check Bank Name
        System.out.println("Choose which bank is your:\n1-NBE\n2-QNB\n3-CIB");
        boolean isValid = true;
        do {
            try {
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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.nextLine(); // Consume the invalid input
                isValid=false;
            }
        }while (!isValid);

        //CardNum Check
        String cardNum;
        System.out.println("Enter your card number");
        Boolean isCardNumValid = true;
        do {
            isCardNumValid=true;

            cardNum = in.nextLine();
//            in.nextLine();

            String cardNumRegex = "^\\d{16}$";

            if (!cardNum.matches(cardNumRegex)) {
                isCardNumValid = false;
                System.out.println("Wrong input, Try Again!");
            }

            for(BankUser bankUsers:listOfBankUser){
                if (bankUsers.getCardNum().equals(cardNum)) {
                    isCardNumValid = false;
                    System.out.println("The card number you entered is already taken");
                    }
            }
        } while (!isCardNumValid);
        user.setCardNum(cardNum);

        //Expiry Date Check
        System.out.println("Enter your card's expiry date ex:MM/YY 'add the slash'");
        String expiryDate;
        boolean isDateValid = true;
        do {
            isDateValid = true;
            expiryDate = in.nextLine();
//            in.nextLine();
            String expiryDateRegex = "^(0[1-9]|1[0-2])/\\d{2}$";

            if (!expiryDate.matches(expiryDateRegex)) {
                isDateValid = false;
                System.out.println("Wrong input, Try Again!");
            }
        } while (!isDateValid);
        user.setExpiryDate(expiryDate);

        //Account Number Check
        System.out.println("Enter your bank account number (it must be 10 numbers):");
        String accountNum;
        boolean isAccountNumValid = true;
        do {
            accountNum = in.nextLine();

            String bankAccountRegex = "^\\d{10}$";

            if (!accountNum.matches(bankAccountRegex)) {
                isAccountNumValid = false;
                System.out.println("Wrong input, Try Again!");
            } else {
                isAccountNumValid = true;
            }

            for(BankUser bankUsers:listOfBankUser){
                if (bankUsers.getAccountNum().equals(accountNum)) {
                    isAccountNumValid = false;
                    System.out.println("The account number you entered is already taken");
                }
            }

        } while (!isAccountNumValid);
        System.out.println("Your card is added successfully!");
        user.setAccountNum(accountNum);

        //Balance Check
        //generates random user balance between 10000 and 20000
        Random random = new Random();
        float randomBalance = 10000 + random.nextFloat() * (20000 - 10000);
        user.bank.setBalance(randomBalance);

        validateOTP();

        System.out.println("Your InstaPay account is created successfully!");
        return user;
    }


    public WalletUser validateWalletUser(WalletUser user) {
        Scanner in=new Scanner(System.in);

        //Balance Check
        //generates random user balance between 10000 and 20000
        Random random = new Random();
        float randomBalance = 10000 + random.nextFloat() * (20000 - 10000);
        float userBalance=randomBalance;


        // Wallet Provider
        System.out.println("Choose your Wallet Provider:");
        System.out.println("1-Mobile Wallet (Vodafone Cash)");
        System.out.println("2-Bank Wallet (EGBank)");
        System.out.println("3-E-Payment Wallet (Telda)");

        boolean isWalletValid = false;
        int choose;
        do {
            try {
                isWalletValid = true;
                choose = in.nextInt();
                in.nextLine(); // Consume the newline character

                switch (choose) {
                    case 1:
                        user.walletProvider = new MobileWallet(userBalance, "MobileWallet", "VodafoneCash");
                        break;
                    case 2:
                        user.walletProvider = new BankWallet(userBalance, "BankWallet", "EGBank");
                        break;
                    case 3:
                        user.walletProvider = new ePaymentWallet(userBalance, "E-PaymentWallet", "Telda");
                        break;
                    default:
                        System.out.println("Wrong input, Try Again!");
                        isWalletValid = false;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                isWalletValid=false;
                in.nextLine(); // Consume the invalid input
            }
        } while (!isWalletValid);

        validateOTP();

        System.out.println("Your InstaPay account is created successfully!");
        return user;
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

        register.verifyRegister();
        database.printUsers();
    System.out.println(database.getListofUser().size());

        register.verifyRegister();
        database.printUsers();

//    register.verifyRegister();
//    database.printUsers();
//
//    register.verifyRegister();
//    database.printUsers();

    System.out.println("size of registered users "+database.getListofUser().size());
    System.out.println("size of registered bank users "+database.getListofBankUser().size());
    System.out.println("size of registered wallet users "+database.getListofBankUser().size());




}


}
