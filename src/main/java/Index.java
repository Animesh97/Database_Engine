import java.util.*;
public class Index {

	public static void main(String[] args) {
		String q;
		HashMap<String,String> fieldList=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Query");				//Insert Query
		q=sc.nextLine();
		
		QueryParameter qp= new QueryParameter();			//Creating Object of Query Parameter Class
		qp.setQry(q);										//Initialising Query Query
		qp.setToken();										//Tokenising Query
		qp.setFile();										//Extracting File Name
		qp.setBase();										//Extracting Base Query
		System.out.println("Filter: "+qp.setFilter());		//Extracting Filter Query
		System.out.println(qp.setConditions());				//Extracting Conditions applied
		System.out.println(qp.setOperators());				//Extracting Operators present
		fieldList=qp.setFields();							//Extracting Fields
		
		AggregateFunctions af=new AggregateFunctions();
		af.getFunctions(q);
		
		FRead read=new FRead();
		read.dataType();
		read.result(fieldList);
	}

}
