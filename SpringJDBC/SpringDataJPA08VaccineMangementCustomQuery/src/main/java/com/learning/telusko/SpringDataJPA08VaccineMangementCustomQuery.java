package com.learning.telusko;

import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataJPA08VaccineMangementCustomQuery {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJPA08VaccineMangementCustomQuery.class, args);
		VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);


		service.fetchVaccineByCompanyName("Comapany3").forEach(v-> System.out.println(v));

		service.fetchVaccineByCompanies("Comapany3","Comapany6").forEach(v-> System.out.println(v));

		service.fetchVaccineByPriceRange(10,1000).forEach(data-> System.out.println(data));

		service.fetchVaccineDetailsByPriceRange(10,1000).forEach(data -> System.out.println(data));

		List<Object[]> vaccinedetails = service.fetchVaccineDetailByVaccineName("vacc1", "vacc2");

		for(Object[] obj:vaccinedetails){
			for(Object vaccine:obj){
				System.out.println(vaccine);
			}
		}

		System.out.println(service.changePriceByVaccine(40,"Pfizer"));

		System.out.println(service.removeVaccine("vacc3"));
		//what will happen if we re-run the query, and data is not present? no error, it will just give 0

		System.out.println(service.removeVaccineByVaccineCostRange(10,1000));

		//System.out.println(service.addVaccineDetails("boaster","Wockhardt","1423"));

		System.out.println("The current time of db is:"+service.getDBDateAndTime());
	}
}



