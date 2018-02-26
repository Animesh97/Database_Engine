
public class AggregateFunctions {
	String token[];
	public String getFunctions(String qury) {
		int i,l;
		String s="";
		token=qury.split("\\s|,");
		l=token.length;
		for(i=0;i<l;i++) {
			if(token[i].indexOf("avg")!=-1 || token[i].indexOf("min")!=-1 || token[i].indexOf("max")!=-1
					|| token[i].indexOf("count")!=-1 || token[i].indexOf("sum")!=-1)
			{
				//System.out.println(token[i].trim());
				s+=token[i].trim();
			}
		}
		System.out.println(s);
		return s;
	}
	
}
