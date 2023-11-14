package User;

public class ePaymentWallet extends WalletProvider {


    public ePaymentWallet(double balance, String providerType,String providerName) {
        super(balance, providerType,providerName);
    }


    @Override
    public boolean validateAPI(String API) {
        return true;
    }
}
