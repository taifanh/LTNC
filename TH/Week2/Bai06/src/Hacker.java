import java.util.ArrayList;

class Transaction {
    private final String transactionID, amount, timestap;

    Transaction(String transactionID, String amount, String timestap) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.timestap = timestap;
    }

    public String toString() {
        return "(" + transactionID + " " + amount + " " + timestap + ")";
    }
}

class Account {
    private ArrayList<Transaction> TransactionList = new ArrayList<>();

    public void addTransaction(Transaction t) {
        TransactionList.add(t);
    }

    public Transaction[] getHistory() {
        Transaction[] history = new Transaction[TransactionList.size()];
        for(int i = 0; i < TransactionList.size(); ++i)
            history[i] = TransactionList.get(i);
        return history;
    }
}

public class Hacker {
    public static void main(String[] args) {
        Account MyAcc = new Account();
        MyAcc.addTransaction(new Transaction("abc", "1000", "12:12"));

        Transaction[] hackerView = MyAcc.getHistory();
        hackerView[0] = null;

        for(Transaction x : MyAcc.getHistory())
            System.out.println(x);
    }
}


