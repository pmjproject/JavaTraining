import java.util.*;
import java.lang.*;
import java.io.*;

class Outer {
    private int x = 1;

    Inner getInner() {
        Inner inner = new Inner();
        return inner;
    }

    class Inner {
        int getX() {
            return x;
        }
    }
}

public class EncapInner
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();
        System.out.println("Private x: "+inner.getX());
    }
}