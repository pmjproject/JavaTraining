import java.io.FileWriter; 
 
public class FileWrite{  
    public static void main(String args[]){    
         try{    
           FileWriter fw=new FileWriter("C:\\Users\\PMJ\\Documents\\assignments\\FileOperation\\Files\\sample.txt");    
           fw.write("Hi Mangalya");    
           fw.close();    
          }catch(Exception e){System.out.println(e);}    
          System.out.println("Success...");    
     }    
}  