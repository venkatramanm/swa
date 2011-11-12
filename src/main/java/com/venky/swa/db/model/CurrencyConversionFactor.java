package com.venky.swa.db.model;

import java.sql.Date;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.IS_NULLABLE;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.column.validations.Mandatory;
import com.venky.swf.db.model.Model;

public interface CurrencyConversionFactor extends Model{
	
	@COLUMN_DEF(StandardDefault.CURRENT_DATE)
	@IS_NULLABLE(false)
	public Date getAsOn();
	public void setAsOn(Date on);
	
	public Currency getFromCurrency();
	@Mandatory
	public int getFromCurrencyId();
	public void setFromCurrencyId(int currencyId);

	
	public Currency getToCurrency();
	@Mandatory
	@COLUMN_DEF(StandardDefault.ONE)
	public int getToCurrencyId();
	public void setToCurrencyId(int currencyId);
	
	public double getConversionFactor();
	public void setConversionFactor(double conversionFactor);
	
}
