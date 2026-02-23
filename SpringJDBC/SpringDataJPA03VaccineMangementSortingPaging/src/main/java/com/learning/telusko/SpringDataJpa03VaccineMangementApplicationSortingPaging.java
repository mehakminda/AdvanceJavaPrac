package com.learning.telusko;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.service.VaccineManagementImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;

@SpringBootApplication
public class SpringDataJpa03VaccineMangementApplicationSortingPaging {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpa03VaccineMangementApplicationSortingPaging.class, args);
		VaccineManagementImpl service =context.getBean(VaccineManagementImpl.class);

		//add few entries in the table for pagination

		System.out.println("********* ASC order *********");
		Iterable<VaccineDetails> vaccineDetailsList=service.fetchDetails(true,"vaccineName","vaccineCompany");
		vaccineDetailsList.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );

		System.out.println("*********** DESC order ************");
		Iterable<VaccineDetails> vaccineDetailsList2=service.fetchDetails(false,"vaccineName","vaccineCompany"); //see the select query
		vaccineDetailsList2.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );


		Iterable<VaccineDetails> vaccineDetailsPagination=null;
		System.out.println(" ********************************************************* Pagination + ASC order *********************************************************");
		vaccineDetailsPagination=service.fetchDataByPageNo(0,3,true,"vaccineName","vaccineCompany");
		vaccineDetailsPagination.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );
		System.out.println("*********  *********");
		vaccineDetailsPagination=service.fetchDataByPageNo(2,3,true,"vaccineName","vaccineCompany");
		vaccineDetailsPagination.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );
		System.out.println("********* *********");
		vaccineDetailsPagination=service.fetchDataByPageNo(1,5,true,"vaccineName","vaccineCompany");
		vaccineDetailsPagination.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );

		System.out.println(" ********************************************************* Pagination+ DESC order  *********************************************************");
		vaccineDetailsPagination=service.fetchDataByPageNo(0,3,false,"vaccineName","vaccineCompany");
		vaccineDetailsPagination.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );
		System.out.println("*********  *********");
		vaccineDetailsPagination=service.fetchDataByPageNo(2,3,false,"vaccineName","vaccineCompany");
		vaccineDetailsPagination.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );
		System.out.println("********* *********");
		vaccineDetailsPagination=service.fetchDataByPageNo(1,5,false,"vaccineName","vaccineCompany");
		vaccineDetailsPagination.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );


		System.out.println(" ***********************************************************************************************");
		service.fetchdetailsByPagination(5);


	}
}
//Pages starts from 0