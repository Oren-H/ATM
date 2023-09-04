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
        double balance = checkBalance(userId);
        accounts.replace(userId, balance + amount);
        return balance;

    }

    public double withdrawMoney(String userId, double amount) throws Exception{
        double balance = checkBalance(userId);
        if(balance >= amount){
            accounts.replace(userId, balance - amount);
            return amount;
        }
        else{
            throw new Exception("Can't withdraw money because you're broke AF lmaooo");
        }
    }

    //public boolean transferMoney(String fromAccount, String toAccount, double amount){

    //}
}