package exception;

public class Exception{

    public static void main(String[] args) {
        System.out.println(division(1,8));
    }

    public static void tryCatchFinally(){
        try{
            throwTester();
        }catch(ArithmeticException e){
            System.out.println("Arithmetic ex : Cannot divide by zero");
        }finally {
            System.out.println("Finally");
        }
    }

    /**
     *  Printed exception. Because finally block always executes then print Finally.
     */
    public static void withoutCatch(){
        try{
            int x = 10/0;
        }finally {
            System.out.println("Finally");
        }
    }

    public static void throwTester() throws ArithmeticException{
        throw new ArithmeticException("Hi");
    }

    static int division(int a, int b) throws ArithmeticException{
        int t = a/b;
        return t;
    }

};

