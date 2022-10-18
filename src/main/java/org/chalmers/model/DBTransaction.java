package org.chalmers.model;

public class DBTransaction extends Transaction{
    private final String bpName;

    public DBTransaction(Transaction transaction, String bpName) {
        super(transaction.getName(), transaction.getAmount(), transaction.getDescription(), transaction.getDateOfTransaction());
        this.bpName = bpName;
    }

    public String getBpName() {
        return bpName;
    }
}
