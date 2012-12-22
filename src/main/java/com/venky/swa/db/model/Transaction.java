package com.venky.swa.db.model;

import java.sql.Date;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.IS_NULLABLE;
import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.column.pm.PARTICIPANT;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;

@MENU("Manage")
public interface Transaction extends Model{
	@IS_VIRTUAL
	public int getTransactionAge();
	
	@COLUMN_DEF(StandardDefault.CURRENT_DATE)
	public Date getTransactionDate();
	public void setTransactionDate(Date date);

	public String getDescription();
	public void setDescription(String description);
	
	@IS_NULLABLE(false)
	@PARTICIPANT
	public Integer getFromAccountId();
	public void setFromAccountId(Integer fromAccountId);
	public Account getFromAccount();
	
	@IS_NULLABLE(false)
	@PARTICIPANT
	public Integer getToAccountId();
	public void setToAccountId(Integer toAccountId);
	public Account getToAccount();
	
	public double getTransactionAmount(); 
	public void setTransactionAmount(double transactionAmount);

	@IS_NULLABLE(false)
	@COLUMN_DEF(StandardDefault.ONE)
	public Integer getCurrencyId();
	public void setCurrencyId(Integer currencyId);
	public Currency getCurrency();
	
}
