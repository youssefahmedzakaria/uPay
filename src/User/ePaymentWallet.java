package User;

public class ePaymentWallet extends WalletProvider{
    private String providerName;
    private double balance;
    private String providerType;

    public ePaymentWallet(String providerName, double balance, String providerType) {
        this.providerName = providerName;
        this.balance = balance;
        this.providerType = providerType;
    }

    public ePaymentWallet() {
        this.providerName = "";
        this.balance = 0;
        this.providerType = "";
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getProviderType() {
        return providerType;
    }

    public boolean validateAPI(String API) {
        return true;
    }
}