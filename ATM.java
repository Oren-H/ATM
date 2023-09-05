import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ATM {
    private HashMap <String, Double> accounts; 

    public ATM (){
        this.accounts = new HashMap<>();
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
            throw new Exception("No account found under " + userId);
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

    public boolean transferMoney(String fromAccount, String toAccount, double amount) throws Exception{
        withdrawMoney(fromAccount, amount);
        depositMoney(toAccount, amount);
        return true;
    }

    public void audit(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("AccountAudit.txt"));
            for (Map.Entry<String, Double> entry : accounts.entrySet()) {
                bw.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}