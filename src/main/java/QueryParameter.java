import java.util.ArrayList;

public class QueryParameter {
	String qry,base,filter,file,token[];
	ArrayList<String> condition,operator,field;
	public void setQry(String qry) {
		this.qry = qry;
	}

	public String setFile() {
		int i;
		for(i=0;i<token.length;i++) {
			if(token[i].equals("from"))
				break;
		}
		this.file = token[i+1];
		return this.file;
	}

	public void setToken() {
		this.token = qry.split(",|\\s");
	}

	public String setBase() {
		int i=qry.indexOf("where");
		if(i==-1)
			this.base = qry;
		else
			this.base=qry.substring(0, i);
		return this.base.trim();
	}

	public QueryParameter() {
		super();
		condition = new ArrayList<String>();
		operator = new ArrayList<String>();
		field = new ArrayList<String>();
	}

	public String setFilter() {
		int i=qry.indexOf("where");
		if(i==-1)
			this.filter = "NULL";
		else
			this.filter=qry.substring(i+6);
		return this.filter.trim();
	}

	public String setConditions() {
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

	public String setOperators() {
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

	public void setFields() {
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
	
}
