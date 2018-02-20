import java.util.*;
public class DB_Engine {
	String qry,token[],file,base,filter;
	public static void main(String[] args) {
		String s;
		int i,l;
		Scanner sc=new Scanner(System.in);
		DB_Engine db = new DB_Engine();
		System.out.println("Enter the query");
		s=sc.nextLine();
		db.setQry(s);
	//Splitting the query
		db.setToken();
		l=db.token.length;
		for(i=0;i<l;i++)
			System.out.println(db.token[i]);
	//Getting the File name
		db.setFile();
		System.out.println("File Name: "+db.file);
	//Getting Base Part
		db.setBase();
		System.out.println("Base Part of the query is: "+db.base);
	//Getting Filter Part
		db.setFilter();
		System.out.println("Filter Part of query is: "+db.filter);
	//Displaying Conditions in the Query
		System.out.println("Conditions in the query are:");
		db.displayConditions();
	//Displaying Operators in the Query
		System.out.println("Operators in the Query are:");
		db.displayOperators();
	//Displaying Fields
		System.out.println("The Fields in the Query are:");
		db.displayFields();
	//Extracting Order By Fields
		System.out.println("Order By Fields are:");
		db.displayOrderFields();
	//Extracting Group BY Fields
		System.out.println("Group By Fields are:");
		db.displayGroupFields();
	//Extracting Aggregate Functions
		System.out.println("Aggregate Functions are:");
		db.displayAggregateFields();
	}
	public void setQry(String qry) {
		this.qry = qry;
	}
	public void setToken() {
		this.token = qry.split(",|\\s");
	}
	public void setFile() {
		int i;
		for(i=0;i<token.length;i++) {
			if(token[i].equals("from"))
				break;
		}
		this.file = token[i+1];
	}
	public void setBase() {
		int i=qry.indexOf("where");
		if(i==-1)
			this.base = qry;
		else
			this.base=qry.substring(0, i);
	}
	public void setFilter() {
		int i=qry.indexOf("where");
		if(i==-1)
			this.filter = "NULL";
		else
			this.filter=qry.substring(i+6);
	}
	void displayConditions() {
		int i,l;
		l=token.length;
		for(i=0;i<l;i++)
		{
			if(token[i].equals("<") || token[i].equals(">") || token[i].equals(">=") || 
					token[i].equals("<=") || token[i].equals("=") || token[i].equals("like") || token[i].equals("!="))
				System.out.println(token[i-1]+token[i]+token[i+1]);
		}
	}
	void displayOperators() {
		int i,l;
		l=token.length;
		for(i=0;i<l;i++) {
			if(token[i].equalsIgnoreCase("AND") || token[i].equalsIgnoreCase("OR") || token[i].equalsIgnoreCase("NOT"))
				System.out.println(token[i]);
		}
	}
	void displayFields() {
		int p,i,l;
		p=base.indexOf("from");
		String temp=base.substring(7, p-1);
		String[] field=temp.split(",");
		l=field.length;
		for(i=0;i<l;i++) {
			if(field[i].indexOf("min")!=-1 || field[i].indexOf("max")!=-1 || field[i].indexOf("sum")!=-1 || field[i].indexOf("avg")!=-1) {
				System.out.println(field[i].substring(4, field[i].length()-1));
			}
			else if(field[i].indexOf("count")!=-1 ) {
				System.out.println(field[i].substring(5, field[i].length()-1));
			}
			else
				System.out.println(field[i]);
		}
	}
	void displayOrderFields() {
		int i,l;
		l=token.length;
		for(i=0;i<l;i++) {
			if(token[i].equalsIgnoreCase("order") && token[i+1].equalsIgnoreCase("by")) {
				System.out.println(token[i+2]);
				return;
			}
		}
		System.out.println("NULL");
	}
	void displayGroupFields() {
		int i,l;
		l=token.length;
		for(i=0;i<l;i++) {
			if(token[i].equalsIgnoreCase("group") && token[i+1].equalsIgnoreCase("by")) {
				System.out.println(token[i+2]);
				return;
			}
		}
		System.out.println("NULL");
	}
	void displayAggregateFields() {
		int i,l;
		l=token.length;
		for(i=0;i<l;i++) {
			if(token[i].indexOf("avg")!=-1 || token[i].indexOf("min")!=-1 || token[i].indexOf("max")!=-1
					|| token[i].indexOf("count")!=-1 || token[i].indexOf("sum")!=-1)
				System.out.println(token[i]);
		}
	}
	
}
/*select * from ipl.csv where season > 2016 and city= 'Bangalore' order by win_by_runs*/
/*select season,winner,player_match from ipl.csv where season > 2014 and city='Bangalore' or date > '31-12-2014'*/