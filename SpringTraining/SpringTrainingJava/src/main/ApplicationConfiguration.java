package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mangalya.training.salesmanager.repository.EmployeeRepository;
import com.mangalya.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.mangalya.training.salesmanager.service.EmployeeService;
import com.mangalya.training.salesmanager.service.EmployeeServiceImpl;


@Configuration
@ComponentScan("com.mangalya")
public class ApplicationConfiguration {
	
	@Bean(name="employeeService")
	@Scope("prototype")
	public EmployeeService getEmployeeService() {
		
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		
		return employeeService;
	}
	
//	@Bean(name="employeeRepository")
//	public EmployeeRepository getEmployeeRepository() {
//		return new  HibernateEmployeeRepositoryImpl();
//	}

}
