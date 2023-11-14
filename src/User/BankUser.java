package User;

public class BankUser extends User {
    private String cardNum;
    private String expiryDate;
    private String accountNum;

    public Bank bank;

    public BankUser(String username, String passsword, int phoneNum, int pin, String accountType, String cardNum, String expiryDate, String accountNum, Bank bank) {
        super(username, passsword, phoneNum, pin, accountType);
        this.cardNum = cardNum;
        this.expiryDate = expiryDate;
        this.accountNum = accountNum;
        this.bank = bank;
    }
    public BankUser(String username, String passsword, int phoneNum, int pin, String accountType){
        super(username, passsword, phoneNum, pin, accountType);
        bank=new Bank();
    }




    public void setCardNum(String cardNum) {

        this.cardNum = cardNum;
    }

    public String getCardNum() {

        return cardNum;
    }

    public void setExpiryDate(String expiryDate) {

        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {

        return expiryDate;
    }

    public void setAccountNum(String accountNum) {

        this.accountNum = accountNum;
    }

    public String getAccountNum() {

        return accountNum;
    }


    public void changePIN(int newPin) {
        setPin(newPin);
        System.out.println("PIN changed successfully");
    }

    @Override
    public double inquireBalance()  {
        return bank.getBalance();
    }
    @Override
    public void setNewBalance(double newBalance){

        bank.setBalance(newBalance);
    }


    public static void main(String[] args) {
        System.out.println("test bank class");
    }
}
