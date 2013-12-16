/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa.db.model;

import java.sql.Date;
import java.util.List;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.IS_NULLABLE;
import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.column.UNIQUE_KEY;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.column.indexing.Index;
import com.venky.swf.db.annotations.column.pm.PARTICIPANT;
import com.venky.swf.db.annotations.model.CONFIGURATION;
import com.venky.swf.db.annotations.model.HAS_DESCRIPTION_FIELD;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.annotations.model.ORDER_BY;
import com.venky.swf.db.model.Model;

/**
 *
 * @author venky
 */
@HAS_DESCRIPTION_FIELD
@CONFIGURATION
@MENU("Manage")
@ORDER_BY("NAME DESC")
public interface Account extends Model{
	@Index 
	@UNIQUE_KEY
    public String getName();
    public void setName(String name);
    
    @IS_NULLABLE(false)
    @Index
    public Integer getAccountTypeId();
    public void setAccountTypeId(Integer accountTypeId);
    public AccountType getAccountType();
    
	@IS_NULLABLE(false)
	@COLUMN_DEF(StandardDefault.ONE)
	public Integer getCurrencyId();
	public void setCurrencyId(Integer currencyId);
	public Currency getCurrency();

	@IS_VIRTUAL 
	public double getBalance();
	

	@IS_NULLABLE
	@COLUMN_DEF(StandardDefault.NULL)
	public Date getBookingDate();
	public void setBookingDate(Date bookDate);

	@IS_NULLABLE
	@COLUMN_DEF(StandardDefault.NULL)
	public Date getEndDate();
	public void setEndDate(Date endDate);
	
	@IS_NULLABLE
	@COLUMN_DEF(StandardDefault.NULL)
	public Double getInterestRate();
	public void setInterestRate(Double rate);
	
	
    @IS_VIRTUAL
    @IS_NULLABLE
    public Double getIncomeTax();
    
    
    public List<Transaction> getTransactions();
    
    @PARTICIPANT
    public Integer getCreatorUserId();
}
