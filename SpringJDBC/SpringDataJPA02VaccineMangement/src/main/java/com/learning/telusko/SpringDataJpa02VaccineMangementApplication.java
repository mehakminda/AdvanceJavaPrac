package com.learning.telusko;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpa02VaccineMangementApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpa02VaccineMangementApplication.class, args);
		VaccineManagementImpl service =context.getBean(VaccineManagementImpl.class);
		//service.registerVaccineDetails(new VaccineDetails("Pfizer","Comirnaty","20"));

		/*List<VaccineDetails> vaccineList=new ArrayList<>();
		vaccineList.add(new VaccineDetails("vacc1","Comapany1","123"));
		vaccineList.add(new VaccineDetails("vacc2","Comapany2","1223"));
		vaccineList.add(new VaccineDetails("vacc3","Comapany3","13"));

		service.registerMultipleVaccineDetails(vaccineList);
		System.out.println("Check you db");*/

		System.out.println(service.getVaccinesCount());

		if(service.checkAvailability(17L)){
			System.out.println("******  Vaccine is present  ********");
		}
		else{
			System.out.println("********** Vaccine is not present *********");
		}

		service.getAllVacineInfo().forEach(data ->{
			System.out.println(data);
		});

		List<Long>  idList=new ArrayList<Long>();
		idList.add(1L);
		idList.add(2L);
		idList.add(7L);
		idList.add(3L);

		service.getAllVaccineInfoByIds(idList).forEach(data ->{
			System.out.println(data);
		});

		Optional<VaccineDetails> optionalVaccineDetails = service.getVaccineById(12L);
		//method1
		if(optionalVaccineDetails.isPresent())
			System.out.println(optionalVaccineDetails.get());
		else
			System.out.println("Sorry no vaccine found with hte id that you are looking for !!");

		//method2
		System.out.println(optionalVaccineDetails.orElse(new VaccineDetails())); //print optional object else create a new vaccine object
		System.out.println(service.getVaccineById(2l).orElse(new VaccineDetails()));

		//optionalVaccineDetails.orElseThrow(() -> new IllegalArgumentException("Record not found")) ;

		System.out.println(service.removeVaccineById(3L));

		List<Long> vaccineIdsList=new ArrayList<Long>();
		vaccineIdsList.add(15L);
		vaccineIdsList.add(34L);
		System.out.println(service.removeVaccinesById(vaccineIdsList));

		VaccineDetails va=new VaccineDetails();
		va.setId(15L);
		va.setVaccineCompany("Company3");
		va.setVaccineCost("13");
		va.setVaccineName("vacc3");
		System.out.println(service.removeVaccineObject(va));






	}
}
