
import java.util.Scanner;

public class ReverseNumber
{

public static void main(String[] args) {
   
   int reverseN = 0;
   int mod,number;
   
Scanner sc = new Scanner(System.in);

System.out.print("Enter Number : ");

number = sc.nextInt(); 

while(number>0){
   
   mod = number%10;
   
   number = number/10;
   
   reverseN = reverseN*10 + mod;
}

System.out.format("Reverse of entered number is = %d\n", reverseN);
    }
}