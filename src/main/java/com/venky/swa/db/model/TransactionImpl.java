package com.venky.swa.db.model;

import com.venky.swf.db.table.ModelImpl;
import com.venky.swf.db.table.Record;

public class TransactionImpl extends ModelImpl<Transaction>{

	public TransactionImpl(Class<Transaction> modelClass, Record record) {
		super(modelClass, record);
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
