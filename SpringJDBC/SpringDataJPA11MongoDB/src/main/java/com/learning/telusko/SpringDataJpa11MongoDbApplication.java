package com.learning.telusko;

import com.learning.telusko.dto.CustomerDTO;
import com.learning.telusko.generator.IdGenerator;
import com.learning.telusko.service.CustomerServiceImpl;
import com.learning.telusko.service.ICustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJpa11MongoDbApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(SpringDataJpa11MongoDbApplication.class, args);
		ICustomerService service = context.getBean(CustomerServiceImpl.class);
/*
		CustomerDTO c1=new CustomerDTO(1,"Cleopatra","Alexandria");
		System.out.println(service.registerCustomer(c1));

		CustomerDTO c2=new CustomerDTO();
		c2.setCusNo(2);
		System.out.println(service.registerCustomer(c2));

		CustomerDTO c3=new CustomerDTO();
		c3.setCusNo(3);
		c3.setName("Mark");
		System.out.println(service.registerCustomer(c3));


		CustomerDTO c4=new CustomerDTO();
		c4.setCity("Sparta");
		System.out.println(service.registerCustomer(c4));*/

		CustomerDTO c5=new CustomerDTO();
		c5.setId(IdGenerator.generateID());
		c5.setCusNo(5);
		System.out.println(service.registerCustomer(c5)); //see the difference in id generated

		service.findAllCustomers().forEach(data-> System.out.println(data));

		System.out.println(service.removeDocument("699dc5327f2b30e4f282294d"));

		System.out.println(service.removeDocumentByCustNo(2));



	}

}
/**
 *Just like CRUDRepository/SortingAndPagingRepository/JPARepository , we have MongoRepository(I)
 *
 * No where we have written a single NOSQL query.
 */