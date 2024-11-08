package pl.edu.wszib.transaction.chain.generator.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

@Getter
@Setter

public class Transaction {
    private String lastTransaction;
    private double amount;
    private int nonce;
    private String hash;

    public Transaction(String lastTransaction, double amount) {
        this.lastTransaction = lastTransaction;
        this.amount = amount;
        this.nonce = this.findNonce();
        this.hash = DigestUtils.md5Hex(this.amount + this.lastTransaction + this.nonce);
    }

    private int findNonce() {
        nonce = 0;
        while(!DigestUtils.md5Hex(this.amount + this.lastTransaction + this.nonce).endsWith("00000")) {
            this.nonce++;
        }
        return nonce;
    }

    @Override
    public String toString() {
        final String SEPARATOR = ", ";
        return new StringBuilder()
                .append("Hash: ")
                .append(this.getHash())
                .append(SEPARATOR)
                .append("Amount: ")
                .append(this.getAmount())
                .append(SEPARATOR)
                .append("Nonce: ")
                .append(this.getNonce())
                .append(SEPARATOR)
                .append("Last transaction: ")
                .append(this.getLastTransaction())
                .toString();
    }
}
