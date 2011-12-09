package com.venky.swa.db.model;

import java.sql.Date;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.column.pm.PARTICIPANT;
import com.venky.swf.db.annotations.column.validations.Mandatory;
import com.venky.swf.db.model.Model;

public interface Transaction extends Model{
	@COLUMN_DEF(StandardDefault.CURRENT_DATE)
	public Date getTransactionDate();
	public void setTransactionDate(Date date);

	public String getDescription();
	public void setDescription(String description);
	
	@Mandatory
	@PARTICIPANT
	public int getFromAccountId();
	public void setFromAccountId(int fromAccountId);
	public Account getFromAccount();
	
	@Mandatory
	@PARTICIPANT
	public int getToAccountId();
	public void setToAccountId(int toAccountId);
	public Account getToAccount();
	
	public double getTransactionAmount(); 
	public void setTransactionAmount(double transactionAmount);

	@Mandatory
	@COLUMN_DEF(StandardDefault.ONE)
	public int getCurrencyId();
	public void setCurrencyId(int currencyId);
	public Currency getCurrency();
	
}
