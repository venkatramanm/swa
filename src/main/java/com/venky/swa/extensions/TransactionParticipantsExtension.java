package com.venky.swa.extensions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.venky.extension.Extension;
import com.venky.extension.Registry;
import com.venky.swa.db.model.Account;
import com.venky.swf.db.model.User;
import com.venky.swf.db.table.Query;

public class TransactionParticipantsExtension implements Extension{
	static {
		Registry.instance().registerExtension(User.GET_PARTICIPATION_OPTION + ".Transaction", new TransactionParticipantsExtension());
	}

	public void invoke(Object... context) {
		User user = (User)context[0];
		String fieldName =  (String)context[1];
		Map<String,List<Integer>> participatingOptions = (Map<String, List<Integer>>)context[2];
		if (fieldName.equalsIgnoreCase("FROM_ACCOUNT_ID") || fieldName.equalsIgnoreCase("TO_ACCOUNT_ID") ){
			Query accountQ = new Query(Account.class);
			accountQ.select().where("1 = 1").and("(" + user.getDataSecurityWhereClause(Account.class) + ")");
			List<Account> accounts = accountQ.execute();
			List<Integer> accountId = new ArrayList<Integer>();
			for (Account account:accounts){
				accountId.add(account.getId());
			}
			participatingOptions.put(fieldName, accountId);
		}
	}

}
