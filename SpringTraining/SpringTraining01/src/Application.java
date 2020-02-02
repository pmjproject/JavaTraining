
import java.util.List;

import com.mangalya.training.salesmanager.model.Employee;
import com.mangalya.training.salesmanager.service.EmployeeService;
import com.mangalya.training.salesmanager.service.EmployeeServiceImpl;


public class Application {
	
	public static void main(String[] arg) {
		
		EmployeeService employeeService = new EmployeeServiceImpl(); 
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			
			System.out.println(employee.getEmployeeName()+ "at" + employee.getEmployeeLocation());
		}
		
	}

}
