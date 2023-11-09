package User;

public class BankUser extends User {
    private String bankName;
    private int cardNum;
    private String expiryDate;

    public BankUser(String username, String password, float balance, int pin, User.userType userType, String bankName, int cardNum, String expiryDate) {
        super(username, password, balance, pin, userType);
        this.bankName = bankName;
        this.cardNum = cardNum;
        this.expiryDate = expiryDate;
    }

    public void changePIN(int newPin) {
        setPin(newPin);
        System.out.println("PIN changed successfully");

    }


    @Override
    public void makePayment(double paymentAmount) {
        if (getBalance() >= paymentAmount) {
            setBalance(getBalance() - paymentAmount);
            System.out.println("Payment successful. Remaining balance: " + getBalance());
        } else {
            System.out.println("Insufficient funds for the payment.");
        }
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankName() {

        return bankName;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    public int getCardNum() {

        return cardNum;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getExpiryDate() {
        return expiryDate;
    }

    public static void main(String[] args) {
        System.out.println("test bank class");
    }


}
