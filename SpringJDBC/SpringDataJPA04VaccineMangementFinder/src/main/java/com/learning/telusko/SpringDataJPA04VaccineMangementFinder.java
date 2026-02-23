package com.learning.telusko;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJPA04VaccineMangementFinder {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJPA04VaccineMangementFinder.class, args);
		VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);

		System.out.println("--------------------------------Finding using the company ---------------------------------------");
		service.searchByVaccineCompany("Comapany3").forEach(data-> System.out.println(data));

		System.out.println("--------------------------------Finding using the price ---------------------------------------");
		service.searchByPrice(15).forEach(data-> System.out.println(data));

		System.out.println("--------------------------------Finding using the price less than some amount ---------------------------------------");
		service.searchByPriceLessThan(1500).forEach(data-> System.out.println(data));


		System.out.println("--------------------------------Finding using the vaccine name from a list of values and price in some range ---------------------------------------");
		List<String>  vaccineDetailsList=new ArrayList<>();
		vaccineDetailsList.add("vacc1");
		vaccineDetailsList.add("vacc3");
		//vaccineDetailsList.add("PFizer");
		List<VaccineDetails> list1=service.searchByVaccineNameInAndVaccineCostBetween(vaccineDetailsList,"20","1000");
				list1.forEach(data-> System.out.println(data));
	}
}

/***
 * Question: why is this line not giving error, service.searchByPrice(15).forEach(data-> System.out.println(data)); as I have pass integer but vaccinecost accepts string
 * Answer: does not give an error because of Java's type conversion and method signature design in your service layer.
 *
 */