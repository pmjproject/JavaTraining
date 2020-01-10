import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


class MyFileReaderTest {

    public void  upper(String inputTextValue){
        String result = "";
        char ch = ' ';
        for (int i = 0; i < inputTextValue.length(); i++) {

            //check valid alphabet and it is in lowercase
            if (inputTextValue.charAt(i) >= 'a' && inputTextValue.charAt(i) <= 'z') {
                ch = (char) (inputTextValue.charAt(i) - 32);
            }
            //else keep the same alphabet or any character
            else {
                ch = (char) (inputTextValue.charAt(i));
            }
            // concatenation, append c to result
            result += ch;
        }
System.out.println(result);

    }

}

public class MyFileTest extends MyFileReaderTest {
    public static void main(String[] args) {

        FileReader fr = null;
        StringBuilder sb = null;
        MyFileTest mf =  new MyFileTest();

        try {
            sb = new StringBuilder();
            fr = new FileReader(new File(args[0]));
            BufferedReader br = new BufferedReader(fr);
            String line;

            while (null != (line = br.readLine())) {
                sb.append(line);
            }

            System.out.println("Input String : " + sb.toString());

            String inputTextValue = sb.toString().replaceAll("\\s+", "");

            mf.upper(inputTextValue);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}