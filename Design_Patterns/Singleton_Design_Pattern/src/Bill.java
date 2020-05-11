import java.util.Scanner;

public class Bill {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Item Price");

        Double itemPrice = myObj.nextDouble();
        Double discount = Discount.getDiscount();
        Double netPrice = itemPrice-discount;


        System.out.println("Net Price is: " + netPrice);  // Output user input
    }
}

