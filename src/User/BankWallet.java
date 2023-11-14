package User;

public class BankWallet extends WalletProvider {


    public BankWallet(double balance, String providerType,String providerName) {
        super(balance, providerType,providerName);
    }


    @Override
    public boolean validateAPI(String API) {
        return true;
    }
}
