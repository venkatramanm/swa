package com.venky.swa.db.model;

import com.venky.swf.db.annotations.column.COLUMN_NAME;
import com.venky.swf.db.annotations.column.HOUSEKEEPING;
import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.column.pm.PARTICIPANT;
import com.venky.swf.db.annotations.column.ui.HIDDEN;
import com.venky.swf.db.annotations.column.ui.PROTECTION;

public interface User extends com.venky.swf.db.model.User {
	@COLUMN_NAME("ID")
	@PROTECTION
	@PARTICIPANT
	@HIDDEN
	@HOUSEKEEPING

	public Integer getSelfUserId();
	public void setSelfUserId(Integer id);
	@IS_VIRTUAL
	public User getSelfUser();
}
