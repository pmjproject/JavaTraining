public class LocalInner{
  
 private int data=30;
 
 void display(){ 
 
  class Local{  
   void msg(){System.out.println(data);}  
  }
  
  Local obj2=new Local();  
  obj2.msg();  
  
 }  
 
 public static void main(String args[]){  
  LocalInner obj=new LocalInner();  
  obj.display();  
 } 
 
}  