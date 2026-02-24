package com.learning.telusko;

import com.learning.telusko.bo.CustomerDetails;
import com.learning.telusko.service.CustomerServiceImpl;
import com.learning.telusko.service.ICustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class SpringDataJpa09CustomerDateTimeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringDataJpa09CustomerDateTimeApplication.class, args);
		CustomerServiceImpl service = context.getBean(CustomerServiceImpl.class);

		LocalDateTime dob= LocalDateTime.of(1995,05,8,20,12);
		LocalTime regTime=LocalTime.now();
		LocalDate regDate= LocalDate.now();
		CustomerDetails c1=new CustomerDetails("Jia","Udaipur",dob,regTime,regDate);
		//System.out.println(service.registerCustomer(c1));


		CustomerDetails c2=new CustomerDetails("Rohan","Noida",LocalDateTime.of(1990,1,20,23,59),LocalTime.of(20,30),LocalDate.of(2024,11,29));
		//System.out.println(service.registerCustomer(c2));

		service.getAllCustomer().forEach(data -> System.out.println(data));

	}

}
