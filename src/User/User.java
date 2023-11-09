package User;


public abstract class User {
    protected String username;
    protected String password;
    protected double balance;
    protected int pin;
    private userType userType;

    public User(String username, String password, float balance, int pin, userType userType) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.pin = pin;
        this.userType = userType;
    }


    public enum userType {
        BankUser,
        WalletUser
    }

    public abstract void changePIN(int newPin);

    public abstract void makePayment(double ammount);

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


}
