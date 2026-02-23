package com.learning.telusko;

import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJPA06VaccineMangementStaticProjections {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJPA06VaccineMangementStaticProjections.class, args);
		VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);


		service.searchByVaccineCostLessThan(1500)
				.forEach(data-> System.out.println(data.getVaccineName()+"->"+data.getVaccineCompany())); //these 3 methods are coming from result view interface
		// observe that only name and company is printed
	}
}

