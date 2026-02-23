package com.learning.telusko;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpa04VaccineMangementApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpa04VaccineMangementApplication.class, args);
		VaccineManagementImpl service =context.getBean(VaccineManagementImpl.class);

		VaccineDetails vaccineDetails = new VaccineDetails();
		vaccineDetails.setId(12L);
		vaccineDetails.setVaccineName("vacc1");
		vaccineDetails.setVaccineCost("16");
		vaccineDetails.setVaccineCompany("Comapany6");
		List<VaccineDetails> vaccineDetailsList=service.searchVaccineByGivenData(vaccineDetails,true,"vaccineName","vaccineCompany");
		vaccineDetailsList.forEach(data->{
			System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany());
		});


		List<VaccineDetails> vaccineDetailsList2=service.searchVaccineByGivenObject(vaccineDetails);
		vaccineDetailsList.forEach(data->{
			System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany());
		});

		//System.out.println(service.searchVaccineById(2L)); //we have enable a property to allow lazy loading

		List<Long> listOfIds=new ArrayList<>();
		listOfIds.add(16L);
		listOfIds.add(17L);
		listOfIds.add(200L);
		System.out.println(service.removeVaccineByIds(listOfIds));
	}

}
//we have disabled queries by making spring.jpa.properties.hibernate.format_sql property to false