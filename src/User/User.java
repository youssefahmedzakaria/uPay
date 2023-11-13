package User;


public abstract class User {
    protected String username;
    protected String password;
    protected int phoneNum;
    protected int pin;
    private String accountType;



    public User(String username, String password, int phoneNum, int pin, String accountType) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.pin = pin;
        this.accountType = accountType;
    }

    public User() {
        this.username = "";
        this.password = "";
        this.phoneNum = 0;
        this.pin = 0;
        this.accountType = "";
    }


    public abstract void changePIN(int newPin);

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

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public abstract double inquireBalance();

    public abstract void setNewBalance(double newBalance);

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
