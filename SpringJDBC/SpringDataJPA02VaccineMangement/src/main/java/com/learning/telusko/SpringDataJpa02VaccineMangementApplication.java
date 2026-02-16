package com.learning.telusko;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpa02VaccineMangementApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpa02VaccineMangementApplication.class, args);
		VaccineManagementImpl service =context.getBean(VaccineManagementImpl.class);
		service.registerVaccineDetails(new VaccineDetails("Pfizer","Comirnaty","20"));

		List<VaccineDetails> vaccineList=new ArrayList<>();
		vaccineList.add(new VaccineDetails("vacc1","Comapany1","123"));
		vaccineList.add(new VaccineDetails("vacc2","Comapany2","1223"));
		vaccineList.add(new VaccineDetails("vacc3","Comapany3","13"));

		service.registerMultipleVaccineDetails(vaccineList);
		System.out.println("Check you db");

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
	}
}
