/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa;

import com.venky.core.util.ExceptionUtil;
import com.venky.swf.db.Database;
import com.venky.swf.db.model.User;
import com.venky.swf.db.table.Table;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        user.setEmailId("venky@shipx.in");
        user.setMobileNo("0919845114558");
        user.setPassword("venky12");
        user.setUsername("Venky");
        try {
            user.save();
        } catch (RuntimeException ex) {
            Pattern p = Pattern.compile(".*MOBILE_NO.*", Pattern.DOTALL);
            Matcher m = p.matcher(ExceptionUtil.getRootCause(ex).getMessage());
            Assert.assertTrue(m.matches());
        }
    }
}
