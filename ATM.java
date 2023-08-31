import java.util.HashMap;

public class ATM {
    private HashMap <String, Double> accounts = new HashMap<>(); 

    public ATM (HashMap<String, Double> accounts){
        this.accounts = accounts;
    }

    public void openAccount(String userId, double amount) throws Exception{
        if(!accounts.containsKey(userId)){
            accounts.put(userId, amount);
        }
        else{
            throw new Exception("User already exists");
        }
    }
}