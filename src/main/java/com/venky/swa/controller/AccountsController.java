package com.venky.swa.controller;

import java.util.List;

import com.venky.swa.db.model.Account;
import com.venky.swf.controller.ModelController;
import com.venky.swf.path.Path;

public class AccountsController extends ModelController<Account>{

	public AccountsController(Path path) {
		super(path); 
	}

	public String[] getIncludedFields(){
		if (getPath().action().equals("index")){
			List<String> fields = getReflector().getFields(); 
			//fields.remove("BALANCE");
			fields.remove("INCOME_TAX");
			return fields.toArray(new String[]{});
		}
		return null;
	}
}
