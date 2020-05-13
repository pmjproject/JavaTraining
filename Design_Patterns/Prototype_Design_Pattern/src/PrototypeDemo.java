import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrototypeDemo {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Student Id: ");
        int sid=Integer.parseInt(br.readLine());
        System.out.print("\n");

        System.out.print("Enter Student Name: ");
        String sname=br.readLine();
        System.out.print("\n");



        System.out.print("Enter Student Address: ");
        String saddress=br.readLine();
        System.out.print("\n");

        System.out.print("Enter Student Grade: ");
        int egrade= Integer.parseInt(br.readLine());
        System.out.print("\n");

        StudentDetails e1=new StudentDetails(sid,sname,egrade,saddress);

        e1.showDetails();
        System.out.println("\n");
        StudentDetails e2=(StudentDetails) e1.getClone();
        e2.showDetails();
    }
}

