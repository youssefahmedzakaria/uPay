package User;

public abstract class WalletProvider {
    private double balance;
    private String providerType;

    public WalletProvider(double balance, String providerType) {
        this.balance = balance;
        this.providerType = providerType;
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

    public abstract boolean validateAPI(String API);
}
