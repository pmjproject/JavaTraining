package exception; 

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExceptionExample{

    public static void main(String[] args) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("Documents/assignments/Exception")));
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught!");
            
        }
    }
}