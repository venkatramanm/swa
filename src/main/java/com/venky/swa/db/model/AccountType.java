/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa.db.model;

import com.venky.swf.db.annotations.column.UNIQUE_KEY;
import com.venky.swf.db.annotations.model.CONFIGURATION;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;

/**
 *
 * @author venky
 */
@CONFIGURATION
@MENU("Manage")
public interface AccountType extends Model{
    public boolean isVirtual();
    public void setVirtual(boolean virtual);
    @UNIQUE_KEY
    public String getName();
    public void setName(String name);
}
