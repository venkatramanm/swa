package com.venky.swa.db.model;

import java.util.List;

import com.venky.swf.db.annotations.column.UNIQUE_KEY;
import com.venky.swf.db.annotations.model.CONFIGURATION;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;

@CONFIGURATION
@MENU("Configuration")
public interface Currency extends Model{
	@UNIQUE_KEY
	public String getName();
	public void setName(String name);
	
	public List<Account> getAccounts();
}
