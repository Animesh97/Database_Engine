
public class AggregateFunctions {
	String min,max,sum,count,avg,token[],qry;

	public void setQry(String qry) {
		this.qry = qry;
	}

	public void setToken(String[] token) {
		this.token = qry.split(",|\\s");
	}

	public void setMin(String min) {
		int i,l;
		l=token.length;
		for(i=0;i<l;i++) {
			if(token[i].indexOf("avg")!=-1 || token[i].indexOf("min")!=-1 || token[i].indexOf("max")!=-1
					|| token[i].indexOf("count")!=-1 || token[i].indexOf("sum")!=-1)
				System.out.println(token[i]);
		}
	}

	public void setMax(String max) {
		this.max = max;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
	
}
