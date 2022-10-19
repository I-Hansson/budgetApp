package org.chalmers.model;

import java.util.Calendar;

public class DBTransaction extends Transaction{
    private final String bpName;

    public DBTransaction(Transaction transaction, String bpName) {
        super(transaction.getName(), transaction.getAmount(), transaction.getDescription(), transaction.getDate());
        this.bpName = bpName;
    }

    public DBTransaction(String name, double amount, String description, Calendar date, String bpName) {
        super(name, amount, description, date);
        this.bpName = bpName;
    }

    public String getBpName() {
        return bpName;
    }
}
