package personmarks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class PersonMarks {
	
	public static void main(String[] args) {

	    List<Person> personList = Arrays.asList(
	            new Person("Amith",24),
	            new Person("mangalya",30),
	            new Person("jack",20),
	            new Person("nimal", 40),
	            new Person("kamal",70),
	            new Person("nick",80),
	            new Person("tina",65));


		
	    
	    Map<String, Integer> filterMap =  personList.stream().filter(x->x.getMarks()>60)
                .sorted(Comparator.comparingInt(Person::getMarks))
                .collect(Collectors.toMap(Person::getName, Person::getMarks));
        
	    System.out.println(filterMap);



		
	    		
	}

}
