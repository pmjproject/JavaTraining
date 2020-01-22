package sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Streams3 {
	
	public static void main(String[] args) 
    {
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
         
        List<Integer> listOfIntegers = listOfStrings.stream()
                                        .map(Integer::valueOf)
                                        .collect(Collectors.toList());
         
        System.out.println(listOfIntegers);
    }

}
