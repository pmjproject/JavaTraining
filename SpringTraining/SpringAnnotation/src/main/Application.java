package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mangalya.training.salesmanager.model.Employee;
import com.mangalya.training.salesmanager.service.EmployeeService;
import com.mangalya.training.salesmanager.service.EmployeeServiceImpl;


public class Application {
	
	public static void main(String[] arg) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class); 
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		
		 for(Employee employee : employees) {
		 System.out.println(employee.getEmployeeName()+ "  at  " + employee.getEmployeeLocation()); }
		 
		
//		employees.forEach(x->System.out.println(x.getEmployeeName() + " at "+ x.getEmployeeLocation()));
		
	}

}
