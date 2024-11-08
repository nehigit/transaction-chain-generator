package pl.edu.wszib.transaction.chain.generator;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    public List<Transaction> transactions = new ArrayList<>();
    private static final TransactionRepository instance = new TransactionRepository();

    private TransactionRepository() {
        this.transactions.add(new Transaction("448c2f75c8777838bca523b5e68c1548",12.5));
        this.transactions.add(new Transaction(this.transactions.get(0).getHash(),100));
        this.transactions.add(new Transaction(this.transactions.get(1).getHash(),22521.23));
        this.transactions.add(new Transaction(this.transactions.get(2).getHash(),17.99));
        this.transactions.add(new Transaction(this.transactions.get(3).getHash(),1));
    }

    public static TransactionRepository getInstance() {
        return instance;
    }
}
