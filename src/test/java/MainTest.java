

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
public class MainTest {
	QueryParameter qp=null;
	
	/*@BeforeAll
	void initialise()
	{
		System.out.println("Hello");
	}*/
	@BeforeEach
	void create() {
		System.out.println("In BeforeEach annotation");	
		qp=new QueryParameter();
		
	}
	@Test			//Testing File Name Extraction
	void checkFile() {
		qp.setQry("select * from ipl.csv");
		qp.setToken();
		assertEquals("ipl.csv", qp.setFile());
	}
	@Test			//Testing Base part extraction
	void checkBase() {
		qp.setQry("select * from ipl.csv where season > 2014 and city = 'Bangalore'");
		qp.setToken();
		assertEquals("select * from ipl.csv", qp.setBase());
	}
	@Test			//Testing Filter part extraction
	void checkFilter() {
		qp.setQry("select * from ipl.csv where season > 2014 and city = 'Bangalore'");
		qp.setToken();
		assertEquals("season > 2014 and city = 'Bangalore'", qp.setFilter());
	}
	@Test			//Testing Condition Extraction
	void checkCondition() {
		qp.setQry("select * from ipl.csv where season > 2014 and city = 'Bangalore'");
		qp.setToken();
		assertEquals("season>2014 city='Bangalore'", qp.setConditions());
	}
	@Test
	void checkOperator()
	{
		qp.setQry("select season,winner,player_match from ipl.csv where season > 2014 and city='Bangalore' or date > '31-12-2014'");
		qp.setToken();
		assertEquals("and or", qp.setOperators());
	}
	@AfterEach
	void destroy() {
		qp=null;
	}
}
