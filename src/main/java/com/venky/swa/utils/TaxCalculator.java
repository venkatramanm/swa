package com.venky.swa.utils;

import com.venky.swa.db.model.Account;

public class TaxCalculator {

	
	public static Double getTax(double income,Account incomeAccount){
		Double tax = null;
		if (incomeAccount == null || incomeAccount.getName() == null){
			return tax;
		}
		if (incomeAccount.getName().matches("INCOME.*AY.*12-13") && incomeAccount.getAccountType().getName().equals("INCOME")){
			double FREE_SLAB = 180000;
			double TEN_PCT_SLAB = 320000;
			double TWENTY_PCT_SLAB = 300000;
			
			tax = 0.0;
			income -= FREE_SLAB;

			tax += Math.max(0, Math.min(income,TEN_PCT_SLAB)) * .1;
			income -= TEN_PCT_SLAB;
			
			tax += Math.max(0, Math.min(income,TWENTY_PCT_SLAB)) * .2;
			income -= TWENTY_PCT_SLAB;
			
			tax += Math.max(0, income) * .3;
			
			double cess = .03 * tax;
			tax += cess; 
		}else if (incomeAccount.getName().matches("INCOME.*AY.*13-14") && incomeAccount.getAccountType().getName().equals("INCOME")){
			double FREE_SLAB = 200000;
			double TEN_PCT_SLAB = 300000;
			double TWENTY_PCT_SLAB = 500000;
			
			tax = 0.0;
			income -= FREE_SLAB;

			tax += Math.max(0, Math.min(income,TEN_PCT_SLAB)) * .1;
			income -= TEN_PCT_SLAB;
			
			tax += Math.max(0, Math.min(income,TWENTY_PCT_SLAB)) * .2;
			income -= TWENTY_PCT_SLAB;
			
			tax += Math.max(0, income) * .3;
			
			double cess = .03 * tax;
			tax += cess; 
		}

		
		return tax;
	}
}
