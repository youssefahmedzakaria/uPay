package User;

public abstract class WalletProvider {
    private double balance;
    private String providerType;
    private String providerName;


    public WalletProvider(double balance, String providerType, String providerName) {
        this.balance = balance;
        this.providerType = providerType;
        this.providerName=providerName;
    }

    public WalletProvider() {
        this.balance = 0;
        this.providerType = "";
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

    public void setProviderName(String providerName) {

        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public abstract boolean validateAPI(String API);
}
