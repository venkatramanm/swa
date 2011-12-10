/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa.db.model;

import java.util.List;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.IS_NULLABLE;
import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.column.pm.PARTICIPANT;
import com.venky.swf.db.annotations.column.validations.Mandatory;
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
    
    @Mandatory
    public int getAccountTypeId();
    public void setAccountTypeId(int accountTypeId);
    public AccountType getAccountType();
    
	@Mandatory
	@COLUMN_DEF(StandardDefault.ONE)
	public int getCurrencyId();
	public void setCurrencyId(int currencyId);
	public Currency getCurrency();

	@IS_VIRTUAL
    public double getBalance();
    public void setBalance(double balance);
    
    @IS_VIRTUAL
    @IS_NULLABLE
    public Double getIncomeTax();
    
    
    public List<Transaction> getTransactions();
    
    @PARTICIPANT
    public Integer getCreatorUserId();
}
