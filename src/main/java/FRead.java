import java.io.*;
import java.util.HashMap;
import java.util.List;

public class FRead {
	
	String s[][]=null;
	File file;
	BufferedReader br;
	
	void dataType()							//Function to extract data type of the columns
	{
		s = new String[2][];
		try {
			file = new File("./src/main/resources/ipl.csv");
			br = new BufferedReader(new FileReader(file));
			s[0] = br.readLine().split(",");
			s[1] = br.readLine().split(",");
			for (int i = 0; i < s[1].length; i++) {
				try {
					int temp = Integer.parseInt(s[1][i]);
					System.out.println(s[0][i] + " :Integer");
				} catch (Exception e) {
					System.out.println(s[0][i] + " :String");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void result(HashMap<String,String> fieldList) 
	{
		int l=0,i,j;
		String t=null,arr[]=null;
		try 
		{
			if(fieldList.containsKey("*"))
			{
					while((t=br.readLine())!=null) 
					{
						arr=t.split(",");
						for(i=0;i<arr.length;i++)
						{
							System.out.print(arr[i]+"\t");
						}
						System.out.println();
					}
			}
			else
			{
				while((t=br.readLine())!=null)
				{
					arr=t.split(",");
					for(i=0;i<arr.length;i++)
					{
						if(fieldList.containsKey(s[0][i]))
						{
							System.out.print(arr[i]+"\t\t");
						}
					}
					System.out.println();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
