import java.io.*;

public class FRead {

	public static void main(String[] args) {
		String s[][] = new String[2][];
		try {
			File file = new File("./src/main/resources/ipl.csv");
			BufferedReader br = new BufferedReader(new FileReader(file));
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

}
