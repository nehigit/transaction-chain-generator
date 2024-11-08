package pl.edu.wszib.transaction.chain.generator.core.impl;

import pl.edu.wszib.transaction.chain.generator.model.Transaction;
import pl.edu.wszib.transaction.chain.generator.db.TransactionRepository;
import pl.edu.wszib.transaction.chain.generator.core.ICore;

public class Core implements ICore {
    private TransactionRepository transactionRepository = TransactionRepository.getInstance();
    private static final Core instance = new Core();

    private Core() {}

    @Override
    public void run() {
        for(Transaction transaction : transactionRepository.transactions) {
            System.out.println(transaction);
        }
    }

    public static Core getInstance() {
        return instance;
    }
}
