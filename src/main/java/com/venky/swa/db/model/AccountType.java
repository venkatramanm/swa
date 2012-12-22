/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa.db.model;

import com.venky.swf.db.annotations.model.CONFIGURATION;
import com.venky.swf.db.annotations.model.HAS_DESCRIPTION_FIELD;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;

/**
 *
 * @author venky
 */
@HAS_DESCRIPTION_FIELD
@CONFIGURATION
@MENU("Manage")

public interface AccountType extends Model{
    public boolean isVirtual();
    public void setVirtual(boolean virtual);
    public String getName();
    public void setName(String name);
}
