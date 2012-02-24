package com.venky.swa;

import org.junit.Test;

import com.venky.swf.db.model.User;
import com.venky.swf.sql.Expression;
import com.venky.swf.sql.parser.SQLExpressionParser;
import com.venky.swf.sql.parser.XMLExpressionParser;
import com.venky.xml.XMLDocument;
import com.venky.xml.XMLElement;

public class ExpressionTest {

	@Test
	public void testExpression() {
		String input = "(NAME = 'venky' AND ID = '2') AND ( PASSWORD = x   OR CREATED_AT = '16/10/1971 00:15' )";
		//ExpressionRule r = new SQLExpressionParser.ExpressionRule();
		//r.match(input);
		//System.out.println(r.getMatch().getText());
		
		Expression ex = new SQLExpressionParser(User.class).parse(input);
		System.out.println(ex.getRealSQL());
		
	}
	
	
	@Test
	public void testXMLExpression(){
		XMLDocument doc = new XMLDocument("AND");
		XMLElement root = doc.getDocumentRoot();
		
		XMLElement or = root.createChildElement("OR");
		XMLElement childAnd = or.createChildElement("AND");
		XMLElement eq = childAnd.createChildElement("EQ");
		eq.createChildElement("ColumnName").setNodeValue("NAME");
		eq.createChildElement("Value").setNodeValue("venky");
		eq = childAnd.createChildElement("EQ");
		eq.createChildElement("ColumnName").setNodeValue("ID");
		eq.createChildElement("Value").setNodeValue("2");
		
		eq = or.createChildElement("EQ");
		eq.createChildElement("ColumnName").setNodeValue("PASSWORD");
		eq.createChildElement("Value").setNodeValue("x");
		
		Expression ex = new XMLExpressionParser(User.class).parse(root);
		System.out.println(ex.getRealSQL());
	}

}
