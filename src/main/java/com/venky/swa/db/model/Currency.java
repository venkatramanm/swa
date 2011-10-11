package com.venky.swa.db.model;

import com.venky.swf.db.annotations.model.HAS_DESCRIPTION_COLUMN;
import com.venky.swf.db.model.Model;

@HAS_DESCRIPTION_COLUMN
public interface Currency extends Model{
	public String getName();
	public void setName(String name);
}
