package User;

public class ePaymentWallet extends WalletProvider {

    private String providerName;

    public ePaymentWallet(double balance, String providerType,String providerName) {
        super(balance, providerType);
        this.providerName = providerName;
    }

    public void setProviderName(String providerName) {

        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    @Override
    public boolean validateAPI(String API) {
        return true;
    }
}
