/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa.db.model;

import java.util.List;

import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.model.HAS_DESCRIPTION_COLUMN;
import com.venky.swf.db.model.Model;

/**
 *
 * @author venky
 */
@HAS_DESCRIPTION_COLUMN
public interface Account extends Model{
    public String getName();
    public void setName(String name);
    
    public int getAccountTypeId();
    public void setAccountTypeId(int accountTypeId);
    public AccountType getAccountType();
    
    
    public List<Transaction> getTransactions();
    @IS_VIRTUAL
    public double getBalance();
    public void setBalance(double balance);
}
