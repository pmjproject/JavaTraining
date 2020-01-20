public class MathTable{

	public static void main(String[] args) {

	   System.out.print("       ");
	   for(int m=1; m<10; m++){
   
    System.out.printf("%5d",m);
		
	

}
System.out.println(" \n  --------------------------------------------------");
for(int m=1; m<10; m++){
   
    System.out.printf("%5d |",m);
		for (int i=1; i<10;i++ ) {

		    
		     
           
		    System.out.printf("%5d", i*m);
		
		}
		System.out.println(" \n");

}
 System.out.println("  --------------------------------------------------");
	}

}