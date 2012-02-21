package com.venky.swa;

import org.junit.Test;

import com.venky.swf.db.model.User;
import com.venky.swf.sql.Expression;
import com.venky.swf.sql.parser.SQLExpressionParser;

public class ExpressionTest {

	@Test
	public void testExpression() {
		String input = "((NAME = 'venky' AND ID = 2) OR ( ( PASSWORD = 'x' ) ))";
		//ExpressionRule r = new SQLExpressionParser.ExpressionRule();
		//r.match(input);
		//System.out.println(r.getMatch().getText());
		
		Expression ex = new SQLExpressionParser(User.class).parse(input);
		System.out.println(ex.getRealSQL());
		
	}

}
