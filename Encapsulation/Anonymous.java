interface Test {
public void test();
}

public class Anonymous{
private String h = "Mangalya";

public static void main(String[] args) {
    Anonymous t = new Anonymous();
}

public Anonymous() {
    Test t = new Test() {
        public void test()  {
            System.out.println( h );
        }
    };

    t.test();
}

}
