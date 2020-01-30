
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mangalya.training.salesmanager.model.Employee;
import com.mangalya.training.salesmanager.service.EmployeeService;
//import com.mangalya.training.salesmanager.service.EmployeeServiceImpl;


public class Application {
	
	public static void main(String[] arg) {
		
		ApplicationContext applicationContext = new ClassPathApplicationContext("applicationContext.xml");
		
		
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class); 
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			
			System.out.println(employee.getEmployeeName()+ "  at  " + employee.getEmployeeLocation());
		}
		
	}

}
