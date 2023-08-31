import java.util.HashMap;

public class ATM{
    private HashMap <String, Double> accounts = new HashMap<>(); 

    public ATM (HashMap<String, Double> accounts){
        this.accounts = accounts;
    }
}