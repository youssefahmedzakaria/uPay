package User;

public class MobileWallet extends WalletProvider {

    private String providerName;

    public MobileWallet(double balance, String providerType,String providerName) {
        super(balance, providerType,providerName);

    }


    @Override
    public boolean validateAPI(String API) {
        return true;
    }
}
