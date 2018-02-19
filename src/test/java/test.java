import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class test {

	/*QueryParameter qp=null;*/
	@BeforeEach
	void create() {
		System.out.println("In BeforeEach annotation");
		/*qp=new QueryParameter();
		qp.setQry("select * from ipl.csv");*/
	}
	@Test
	void check() {
		/*qp.setToken();
		assertEquals("Wrong File Name","ipl.csv",qp.setFile());*/
	}
	@AfterEach
	void destroy() {
		//qp=null;
	}
}
