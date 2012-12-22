package com.venky.swa.db.model;

import java.util.List;

import com.venky.swf.db.annotations.model.CONFIGURATION;
import com.venky.swf.db.annotations.model.HAS_DESCRIPTION_FIELD;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;

@HAS_DESCRIPTION_FIELD
@CONFIGURATION
@MENU("Configuration")

public interface Currency extends Model{
	public String getName();
	public void setName(String name);
	
	public List<Account> getAccounts();
}
