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

    public double checkBalance(String userId) throws Exception{
        if(accounts.containsKey(userId)){
            return accounts.get(userId);
        }
        else{
            throw new Exception("Account does not exist");
        }
    }

    public double depositMoney(String userId, double amount) throws Exception{
        if(accounts.containsKey(userId)){
             accounts.replace(userId, accounts.get(userId) + amount);
             return amount;
        }
        else{
            throw new Exception("Account does not exist");
        }
    }

    public double withdrawMoney(String userId, double amount) throws Exception{
        double currBalance = accounts.get(userId);
        if(currBalance >= amount){
            accounts.replace(userId, currBalance - amount);
            return amount;
        }
        else{
            throw new Exception("Can't withdraw money because you're broke AF lmaooo");
        }
    }
}