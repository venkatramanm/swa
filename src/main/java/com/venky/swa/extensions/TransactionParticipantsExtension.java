package com.venky.swa.extensions;

import java.util.ArrayList;
import java.util.List;

import com.venky.swa.db.model.Account;
import com.venky.swa.db.model.Transaction;
import com.venky.swf.db.extensions.ParticipantExtension;
import com.venky.swf.db.model.User;
import com.venky.swf.sql.Select;

public class TransactionParticipantsExtension extends ParticipantExtension<Transaction>{
	protected TransactionParticipantsExtension() {
		super();  
	}

	static {
		registerExtension(new TransactionParticipantsExtension());
	}

	@Override
	protected List<Integer> getAllowedFieldValues(User user, Transaction partiallyFilledModel, String fieldName) {
		if (fieldName.equalsIgnoreCase("FROM_ACCOUNT_ID") || fieldName.equalsIgnoreCase("TO_ACCOUNT_ID") ){
			Select accountQ = new Select().from(Account.class);
			accountQ.where(user.getDataSecurityWhereClause(Account.class));
			List<Account> accounts = accountQ.execute();
			List<Integer> accountId = new ArrayList<Integer>();
			for (Account account:accounts){
				accountId.add(account.getId());
			}
			return accountId;
		}
		return null;
	}

}
