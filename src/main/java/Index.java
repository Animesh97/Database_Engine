import java.util.*;
public class Index {

	public static void main(String[] args) {
		String q;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Query");
		q=sc.nextLine();
		
		QueryParameter qp= new QueryParameter();
		qp.setQry(q);
		qp.setToken();
		qp.setFile();
		qp.setBase();
		System.out.println("Filter: "+qp.setFilter());
		System.out.println(qp.setConditions());
		System.out.println(qp.setOperators());
		qp.setFields();
	}

}
