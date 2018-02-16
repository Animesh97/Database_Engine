import java.util.Scanner;

public class Query {
	
	String qry,cls,base,filter;
	
	public void setQry(String qry) 			//Getter Method
	{
		this.qry = qry;
	}

	String returnClass(String s[])			//Returns class name from query
	{
		int l=s.length,i;
		for(i=0;i<l;i++)
		{
			if(s[i].indexOf('.')!=-1)
				return s[i];
		}
		return null;
	}
	
	public static void main(String[] args) 
	{
		int i,l;
		String s,token[];
		Scanner sc=new Scanner(System.in);
		Query obj=new Query();
		System.out.println("Enter the Query");
		s=sc.nextLine();
		obj.setQry(s);
		token=obj.qry.split("\\s");
		l=token.length;
		System.out.println("Tokens:");
		for(i=0;i<l;i++)
			System.out.print(token[i]+" ");
	//Extract Class Name
		obj.cls=obj.returnClass(token);				//Return Class Called
		if(obj.cls!=null)
			System.out.println("\nClass Name: "+obj.cls);
		else
			System.out.println("\nClass name not found");
		i=obj.qry.indexOf("where");
	//Extract base query
		obj.base=obj.qry.substring(0, i);	
	//Extract filter query
		obj.filter=obj.qry.substring(i+6);			
		System.out.println("Base Query is: "+obj.base);			
		System.out.println("Filter Query is: "+obj.filter);
	//Extract conditions
		System.out.println("Conditions in Query are:");
		for(i=0;i<l;i++)
		{
			if(token[i].equals("<") || token[i].equals(">") || token[i].equals(">=") || 
					token[i].equals("<=") || token[i].equals("=") || token[i].equals("like") || token[i].equals("!="))
				System.out.println(token[i-1]+token[i]+token[i+1]);
		}
	//Extracting Logical Operators
		
	}
}

