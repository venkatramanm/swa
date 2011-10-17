/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.venky.swf.db.Database;
import com.venky.swf.db.model.User;
import com.venky.swf.db.table.Table;

/**
 *
 * @author venky
 */
public class UserTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        Database.getInstance().open();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Database.getInstance().close();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        Table<User> userTable = Database.getInstance().getTable(User.class);
        User user = userTable.newRecord();
        user.setPassword("venky12");
        user.setName("Venky");
        user.save();
    }
}
