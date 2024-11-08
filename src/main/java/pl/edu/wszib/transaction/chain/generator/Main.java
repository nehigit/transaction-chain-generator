package pl.edu.wszib.transaction.chain.generator;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Transaction t1 = new Transaction("448c2f75c8777838bca523b5e68c1548", 12.5);
        Transaction t2 = new Transaction(t1.getHash(), 100);
        Transaction t3 = new Transaction(t2.getHash(), 22521.23);
        Transaction t4 = new Transaction(t3.getHash(), 17.99);
        Transaction t5 = new Transaction(t4.getHash(), 1);

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);
        transactions.add(t4);
        transactions.add(t5);

        for(Transaction transaction : transactions) {
            System.out.println(transaction);
        }

    }
}