package factory;

import java.util.Scanner;

public class FactoryPattern {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Phone Type(Low Price / Middle Price/ Expencive Price)");

        String type = myObj.nextLine();

        PhoneFactory phoneFactory = new PhoneFactory();
        Phone phone = phoneFactory.getPhone(type);
        phone.show();
    }
}
