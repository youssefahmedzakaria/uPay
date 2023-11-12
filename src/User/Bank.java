package User;

public class Bank {
    private double balance;
    private String bankName;



    public Bank(String bankName, double balance) {
        this.bankName = bankName;
        this.balance = balance;
    }

    public Bank() {
        this.balance = 0;
        this.bankName = "";
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public boolean validateAPI(String API) {
        return true;
    }
}
