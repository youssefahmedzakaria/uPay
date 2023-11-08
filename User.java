public abstract class User {
    protected String username;
    protected String password;
    protected float balance;
    protected int pin;

    public User(String username, String password, float balance, int pin) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.pin = pin;
    }

    public abstract void changePIN(int newPin);

    public abstract void makePayment();

}
