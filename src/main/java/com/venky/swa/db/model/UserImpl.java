package com.venky.swa.db.model;

import com.venky.swf.db.table.ModelImpl;

public class UserImpl extends ModelImpl<User> {

	public UserImpl(User proxy) {
		super(proxy);
	}

	public User getSelfUser(){
		return getProxy();
	}
}
