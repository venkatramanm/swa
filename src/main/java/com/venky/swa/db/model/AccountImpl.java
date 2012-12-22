package com.venky.swa.db.model;

import com.venky.swa.utils.CurrencyConverter;
import com.venky.swa.utils.TaxCalculator;
import com.venky.swf.db.table.ModelImpl;

public class AccountImpl extends ModelImpl<Account>{

	public AccountImpl(Account proxy) {
		super(proxy);
	}
	
	public double getBalance(){
		double balance = 0;
		for (Transaction t : getChildren(Transaction.class)){
			double tamt = 0 ; 
			if (t.getFromAccountId() != t.getToAccountId()){
				tamt = t.getTransactionAmount() * (t.getFromAccountId() == getProxy().getId() ? -1 : 1) * CurrencyConverter.getInstance().getConversionFactor(t.getCurrency(),getProxy().getCurrency());
			}
			balance += tamt;
		}
		return balance;
	}
	
	
	public Double getIncomeTax(){
		return TaxCalculator.getTax(Math.abs(getBalance()), getProxy());
	}
	
}
