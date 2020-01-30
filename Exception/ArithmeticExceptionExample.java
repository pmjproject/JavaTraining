public class ArithmeticExceptionExample{
  
  public static void main(String args[]){
  
   try{  
     
  
      int a=100/0;  
      System.out.println(a);  
      }catch(ArithmeticException e){

      System.out.println(e);
      }  
   
 
 
  }  
}  