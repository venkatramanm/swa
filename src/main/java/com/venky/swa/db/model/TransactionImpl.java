package com.venky.swa.db.model;

import java.sql.Date;

import com.venky.core.date.DateUtils;
import com.venky.swf.db.table.ModelImpl;
import com.venky.swf.db.table.Record;

public class TransactionImpl extends ModelImpl<Transaction>{

	public TransactionImpl(Class<Transaction> modelClass, Record record) {
		super(modelClass, record);
	}
	public int getTransactionAge(){
		Date tDate = getProxy().getTransactionDate();
		
		if (tDate != null){
			return DateUtils.compareToMinutes( System.currentTimeMillis(),tDate.getTime())/(60*24);
		}
		
		return 0;
	}
	@Override
	protected boolean isModelValid(StringBuilder totalMessage) {
		boolean valid = super.isModelValid(totalMessage);
		if (valid){
			Transaction t = getProxy();
			if (t.getFromAccount() == null){
				totalMessage.append("Invalid From Account<br/>");
				valid = false; 
			}
			if (t.getToAccount() == null){
				totalMessage.append("Invalid To Account<br/>");
				valid = false; 
			}
			
			if (t.getFromAccountId() == t.getToAccountId()){
				totalMessage.append("From and to Accounts are same!<br/>");
				valid = false;
			}
			
		}
		return valid;
	}

	
}
