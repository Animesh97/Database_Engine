import java.io.*;
public class FRead {

	public static void main(String[] args) {
		String s=null;
		try {
			File file=new File("./src/main/resources/ipl.csv");
			BufferedReader br=new BufferedReader(new FileReader(file));
			while((s=br.readLine())!=null)
				System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
