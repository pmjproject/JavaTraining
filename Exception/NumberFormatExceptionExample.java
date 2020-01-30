public class NumberFormatExceptionExample {  
  
    public static void main(String[] args) {
        try {
            
            String s = "mangalya";
            int i = Integer.parseInt(s);

            
            System.out.println("int value = " + i);
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException");  
        }
    }
}