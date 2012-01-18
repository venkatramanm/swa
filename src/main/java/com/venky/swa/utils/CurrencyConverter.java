package com.venky.swa.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.venky.core.date.DateUtils;
import com.venky.swa.db.model.Currency;
import com.venky.swa.db.model.CurrencyConversionFactor;
import com.venky.swf.db.table.BindVariable;
import com.venky.swf.sql.Conjunction;
import com.venky.swf.sql.Expression;
import com.venky.swf.sql.Operator;
import com.venky.swf.sql.Select;

public class CurrencyConverter {
	private static final CurrencyConverter converter = new CurrencyConverter();
	private CurrencyConverter(){
		
	}
	public static CurrencyConverter getInstance(){
		return converter;
	}
	
	public double convert(double amount , Currency fromCurrency , Currency toCurrency){
		return amount * getConversionFactor(fromCurrency, toCurrency);
	}

	
	public double getConversionFactor(final Currency fromCurrency, final Currency toCurrency){
		double cf = 1; 
		if (fromCurrency.getId() == toCurrency.getId()){
			return cf;
		}
		Select q = new Select();
		q.from(CurrencyConversionFactor.class);
		Expression whereClause = new Expression(Conjunction.OR);
		
		Expression expression1 =  new Expression(Conjunction.AND);
		expression1.add(new Expression("from_currency_id",Operator.EQ,new BindVariable(fromCurrency.getId())));
		expression1.add(new Expression("to_currency_id",Operator.EQ,new BindVariable(toCurrency.getId())));
		whereClause.add(expression1);
		
		Expression expression2 =  new Expression(Conjunction.AND);
		expression2.add(new Expression("to_currency_id",Operator.EQ,new BindVariable(fromCurrency.getId())));
		expression2.add(new Expression("from_currency_id",Operator.EQ,new BindVariable(toCurrency.getId())));
		whereClause.add(expression2);
		
		q.where(whereClause);
		
		List<CurrencyConversionFactor> cfs = q.execute();
		if (cfs.isEmpty()){
			throw new RuntimeException("Don't know to convert from " + fromCurrency.getName() + " tp " + toCurrency.getName());
		}
		Collections.sort(cfs,new Comparator<CurrencyConversionFactor>() {

			public int compare(CurrencyConversionFactor o1,
					CurrencyConversionFactor o2) {
				long ret = DateUtils.compareToMillis(o2.getAsOn(), o1.getAsOn()); // Latest entry first.
				if (ret == 0){
					if (o1.getFromCurrencyId() != o2.getFromCurrencyId()){
						if (o1.getFromCurrencyId() == fromCurrency.getId()){
							ret = -1; 
						}else if (o1.getFromCurrencyId() == toCurrency.getId()){
							ret = 1;
						}
					}
				}
				return 0;
			}
		});
		
		CurrencyConversionFactor ccf = cfs.get(0);
		cf = ccf.getConversionFactor();
		if (ccf.getFromCurrencyId() == toCurrency.getId()){
			cf = 1.0/cf;
		}
		
		return cf;
	}

}
