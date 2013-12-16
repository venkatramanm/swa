package com.venky.swa.configuration;

import com.venky.swf.configuration.Installer;
import com.venky.swf.db.Database;

public class AppInstaller implements Installer{
	public void install(){
		Database.getJdbcTypeHelper().resetIdGeneration();
	}
}
