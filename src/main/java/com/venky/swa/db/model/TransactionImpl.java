package com.venky.swa.db.model;

import java.sql.Date;

import com.venky.core.date.DateUtils;
import com.venky.swf.db.table.ModelImpl;
import com.venky.swf.exceptions.MultiException;

public class TransactionImpl extends ModelImpl<Transaction>{

	public TransactionImpl(Transaction proxy) {
		super(proxy);
	}
	public int getTransactionAge(){
		Date tDate = getProxy().getTransactionDate();
		
		if (tDate != null){
			return DateUtils.compareToMinutes( System.currentTimeMillis(),tDate.getTime())/(60*24);
		}
		
		return 0;
	}
	@Override
	protected boolean isModelValid(MultiException ex) {
		boolean valid = super.isModelValid(ex);
		if (valid){
			Transaction t = getProxy();
			if (t.getFromAccount() == null){
				ex.add(new RuntimeException("Invalid From Account"));
				valid = false; 
			}
			if (t.getToAccount() == null){
				ex.add(new RuntimeException("Invalid To Account"));
				valid = false; 
			}
			
			if (t.getFromAccountId() == t.getToAccountId()){
				ex.add(new RuntimeException("From and to Accounts are same!"));
				valid = false;
			}
			
		}
		return valid;
	}

	
}
