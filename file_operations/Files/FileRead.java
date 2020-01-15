


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead{

 private static final String FILENAME = "C:\\Users\\PMJ\\Documents\\assignments\\FileOperation\\Files\\sample.txt";

 public static void main(String[] args) {

  try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

   String strCurrentLine;

   while ((strCurrentLine = br.readLine()) != null) {
    System.out.println(strCurrentLine);
   }

  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}