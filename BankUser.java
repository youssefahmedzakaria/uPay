public class BankUser extends User {
    private String bankName;
    private int cardNum;
    private String expiryDate;

    public BankUser(String username, String password, float balance, int pin, String bankName, int cardNum, String expiryDate) {
        super(username, password, balance, pin);
        this.bankName = bankName;
        this.cardNum = cardNum;
        this.expiryDate = expiryDate;
    }

    @Override
    public void changePIN(int newPin) {
        // Implementation for changing the PIN for a bank user
    }

    @Override
    public void makePayment() {
        // Implementation for payment for a bank user
    }

    public String getBankName() {
        return bankName;
    }

    public int getCardNum() {
        return cardNum;
    }

    public String getExpiryDate() {
        return expiryDate;
    }


}
