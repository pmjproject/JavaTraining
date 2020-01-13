
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRead  {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Input String:");
		String input = br.readLine();
		br.close();
		System.out.println("Output of String = " + new String(input));
	}
}