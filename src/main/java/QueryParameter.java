import java.util.ArrayList;
import java.util.HashMap;

public class QueryParameter {
	String qry,base,filter,file,token[];
	ArrayList<String> condition,operator;
	HashMap<String,String> fieldList;
	
	public void setQry(String qry) {
		this.qry = qry;
	}

	public String setFile() {				//Extract the name of file from given query
		int i;
		for(i=0;i<token.length;i++) {
			if(token[i].equals("from"))
				break;
		}
		this.file = token[i+1];
		return this.file;
	}

	public void setToken() {				//Extract the tokens from given query
		this.token = qry.split(",|\\s");
	}

	public String setBase() {				//Extract the base query from given query
		int i=qry.indexOf("where");
		if(i==-1)
			this.base = qry;
		else
			this.base=qry.substring(0, i);
		return this.base.trim();
	}

	public QueryParameter() {				//Default Constructor
		super();
		condition = new ArrayList<String>();
		operator = new ArrayList<String>();
		fieldList = new HashMap<String,String>();
	}

	public String setFilter() {				//Extract the base query from the given query
		int i=qry.indexOf("where");
		if(i==-1)
			this.filter = "NULL";
		else
			this.filter=qry.substring(i+6);
		return this.filter.trim();
	}

	public String setConditions() {			//Extract the applied conditions in given query
		int i,l;
		String s="";
		l=token.length;
		for(i=0;i<l;i++)
		{
			if(token[i].equals("<") || token[i].equals(">") || token[i].equals(">=") || 
					token[i].equals("<=") || token[i].equals("=") || token[i].equals("like") || token[i].equals("!="))
			{
				System.out.println(token[i-1]+token[i]+token[i+1]);
				s+=token[i-1]+token[i]+token[i+1]+" ";
			}
		}
		return s.trim();
	}

	public String setOperators() {			//Extract the applied operators in the given query
		int i,l;
		String s="";
		l=token.length;
		for(i=0;i<l;i++) {
			if(token[i].equalsIgnoreCase("AND") || token[i].equalsIgnoreCase("OR") || token[i].equalsIgnoreCase("NOT"))
			{
				System.out.println(token[i]);
				s+=token[i]+" ";
			}
		}
		return s.trim();
	}

	public HashMap<String,String> setFields() {				//Extract the field values from given query
		int p,i,l;
		p=base.indexOf("from");
		String temp=base.substring(7, p-1);
		String[] field=temp.split(",");
		l=field.length;
		for(i=0;i<l;i++) {
			if(field[i].indexOf("min")!=-1 || field[i].indexOf("max")!=-1 || field[i].indexOf("sum")!=-1 || field[i].indexOf("avg")!=-1) {
				System.out.println(field[i].substring(4, field[i].length()-1));
				fieldList.put(field[i].substring(4, field[i].length()-1),"1");
			}
			else if(field[i].indexOf("count")!=-1 ) {
				System.out.println(field[i].substring(5, field[i].length()-1));
				fieldList.put(field[i].substring(5, field[i].length()-1),"1");
			}
			else
				System.out.println(field[i]);
			fieldList.put(field[i],"1");
		}
		return fieldList;
	}
	
}
