package com.learning.telusko.dao;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

//@Repository
public interface IVaccineRepository extends JpaRepository<VaccineDetails, Long> {

    //findByproperty
    public List<VaccineDetails> findByVaccineCost(int price);//PropertyName must be same or else we will get error.

   // public List<VaccineDetails> findByVaccineCompany(String companyName);
    //public List<VaccineDetails> findByVaccineCompanyIs(String companyName);
    public List<VaccineDetails> findByVaccineCompanyEquals(String companyName);

    //findByPropertyKeyword
    public List<VaccineDetails> findByVaccineCostLessThan(int price);//PropertyName must be same or else we will get error - VaccineCost.

    //findBYPropertyIn
    public List<VaccineDetails> findByVaccineNameIn(Collection<String> vaccineNames); //select * from table where id in (1,2,3,4);

    //multiple property
    public List<VaccineDetails> findByVaccineNameAndVaccineCost(String vaccineName, String vaccineCost);

    //multiple property with different keywords
    public List<VaccineDetails> findByVaccineNameInAndVaccineCostBetween(Collection<String> vaccineNames, String startingPrice,String endPrice);
    //in for vaccine name and between(range) for vaccine cost

    //Here we give only abstraction, their implementation will be given by in-memory proxy class
}


// search for spring data jpa finder methods in google

/**
 * we have not provided the implmenetation of findByVaccineCompany method, who and hoes does it gets implemented?
 *
 * The findByVaccineCompany method in your IVaccineRepository interface is a Spring Data JPA derived query method.
 *
 * Spring Data JPA (via the JpaRepository infrastructure) provides the implementation dynamically when your application starts.
 *
 *
 * How it works:
 * Spring Data JPA automatically generates the implementation at runtime based on the method name.
 * The method name follows the pattern findBy<propertyname>, where PropertyName matches a field in your VaccineDetails entity (in this case, vaccineCompany).</propertyname>
 * When you call this method, Spring Data JPA constructs the appropriate SQL query to fetch records where vaccineCompany matches the provided companyName.
 */

/**
 * will it work if i user crud repository instead of JPARepository
 */


//without custom query is projection