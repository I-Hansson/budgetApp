package org.chalmers.database;

import org.chalmers.model.Transaction;

import java.util.Calendar;

/**
 * A class that is used to make the interfaces of the model and the database compatible.
 *
 * @author williamfrisk
 */
class DBTransaction extends Transaction {
    private final String bpName;

    public DBTransaction(String name, double amount, String description, Calendar date, String bpName) {
        super(name, amount, description, date);
        this.bpName = bpName;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getBudgetPostName(){
        return bpName;
    }
}
