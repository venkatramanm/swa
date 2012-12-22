package com.venky.swa.db.model;

import java.sql.Date;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.IS_NULLABLE;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.model.CONFIGURATION;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;

@CONFIGURATION
@MENU("Configuration")
public interface CurrencyConversionFactor extends Model{
	
	@COLUMN_DEF(StandardDefault.CURRENT_DATE)
	@IS_NULLABLE(false)
	public Date getAsOn();
	public void setAsOn(Date on);
	
	public Currency getFromCurrency();
	@IS_NULLABLE(false)
	public Integer getFromCurrencyId();
	public void setFromCurrencyId(Integer currencyId);

	
	public Currency getToCurrency();
	
	@IS_NULLABLE(false)
	@COLUMN_DEF(StandardDefault.ONE)
	public Integer getToCurrencyId();
	public void setToCurrencyId(Integer currencyId);
	
	public double getConversionFactor();
	public void setConversionFactor(double conversionFactor);
	
}
