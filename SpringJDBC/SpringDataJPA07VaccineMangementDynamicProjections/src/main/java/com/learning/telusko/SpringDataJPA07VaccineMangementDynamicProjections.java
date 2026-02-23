package com.learning.telusko;

import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataJPA07VaccineMangementDynamicProjections {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJPA07VaccineMangementDynamicProjections.class, args);
		VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);


		List<ResultsView2> list1=service.searchByVaccineCompany("Comapany4",ResultsView2.class);
		//ResultsView2 is an interface, behind the scene an implementation class will be generated and that class will be injected in the repository

		list1.forEach(data-> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()+"->"+data.getId()));

		List<ResultsView1> list2=service.searchByVaccineCompany("Comapany4",ResultsView1.class);
		list2.forEach(data-> System.out.println(data.getVaccineCompany()+"->"+data.getId())); //only these 2 available
	}
}




/**
 * Static projections vs dynamic projections
 *
 * In static projections we have fixed number of variables/columns in output, while in dynamic projections we want different columns in different outputs
 *
 */


