package com.venky.swa.db.model;

import java.sql.Date;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.model.Model;

public interface Transaction extends Model{
	@COLUMN_DEF(StandardDefault.CURRENT_DATE)
	public Date getTransactionDate();
	public void setTransactionDate(Date date);

	public String getDescription();
	public void setDescription(String description);
	
	public Account getFromAccount();
	public long getFromAccountId();
	public void setFromAccountId(long fromAccountId);
	
	public Account getToAccount();
	public long getToAccountId();
	public void setToAccountId(long toAccountId);
	
	public double getTransactionAmount(); 
	public void setTransactionAmount(double transactionAmount);

	public long getCurrencyId();
	public void setCurrencyId(long currencyId);
	public Currency getCurrency();
	
}
