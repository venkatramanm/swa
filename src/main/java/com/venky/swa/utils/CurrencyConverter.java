package com.venky.swa.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.venky.core.date.DateUtils;
import com.venky.swa.db.model.Currency;
import com.venky.swa.db.model.CurrencyConversionFactor;
import com.venky.swf.db.table.BindVariable;
import com.venky.swf.db.table.Query;

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
		Query q = new Query(CurrencyConversionFactor.class);
		q.select().where("((from_currency_id = ? and to_currency_id = ?) or (to_currency_id = ? and from_currency_id = ?))",
				new BindVariable(fromCurrency.getId()),new BindVariable(toCurrency.getId()),
				new BindVariable(fromCurrency.getId()),new BindVariable(toCurrency.getId())
				);
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
