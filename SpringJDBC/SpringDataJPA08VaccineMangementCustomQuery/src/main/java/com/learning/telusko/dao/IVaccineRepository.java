package com.learning.telusko.dao;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

//@Repository
public interface IVaccineRepository extends JpaRepository<VaccineDetails, Long> {


    //These are called custom queries
    //here we use entity names in query
    @Query("from VaccineDetails where vaccineCompany=:company")
    public List<VaccineDetails>  searchVaccineByCompanyName(@Param("company") String cn);
    //different name: then use an annotation @Param()

    @Query("from VaccineDetails where vaccineCompany IN (:cmp1,:cmp2)")
    public List<VaccineDetails> searchVaccineByCompanies(String cmp1, String cmp2);
    //same name:  cn in query and as parameter

    @Query("from VaccineDetails where vaccineCost between :min and :max")
    public List<VaccineDetails> searchVaccineDetailsByPriceRange(int min, int max);

    @Query("select vaccineName,vaccineCompany from VaccineDetails where vaccineCost between :min and :max")
    public List<String> searchVaccineByPriceRange(int min, int max);

    @Query("select vaccineName, vaccineCost from VaccineDetails where vaccineName IN (:vac1, :vac2)")
    public List<Object[]> searchVaccineDetailByVaccineName(String vac1,String vac2);

    @Transactional
    @Modifying
    @Query("UPDATE VaccineDetails SET vaccineCost=:newVaccineCost where vaccineName=:vaccineName")
    public int updatenewVaccineCostByVaccine(Integer newVaccineCost, String vaccineName);

    @Transactional
    @Modifying
    @Query("delete VaccineDetails where vaccineName=:vaccineName")
    public int deleteVaccine(String vaccineName);


    @Transactional
    @Modifying
    @Query("delete VaccineDetails where vaccineCost between :min and :max")
    public int deleteVaccineByVaccineCostRange(Integer min, Integer max);


    @Transactional
    @Modifying
    @Query(value="insert into vaccinedetails (`vaccineName`, `vaccineCompany`, `vaccineCost`) values (?,?,?)",nativeQuery = true) //in query we use the actual table and coulmn names
    public int insertVaccineDetails(String vaccineName, String vaccineCompnay, String vaccineCost);

    //save in crudrepository, is both add and update
    @Query(value="select now() from Dual",nativeQuery=true)
    public java.time.LocalDateTime getTheSystemDateAndTime();


    //The query SELECT NOW() FROM dual is used to retrieve the current date and time from the database.


}

/**
 * Can i use findVaccineByCompanyName instead of searchVaccineByCompanyName?
 *
 * Yes, you can use findVaccineByCompanyName instead of searchVaccineByCompanyName. Spring Data JPA supports method name prefixes like find, read, get, query, search, stream, and count for derived queries.
 * The important part is the property name after the prefix.
 * If you use @Query, the method name can be anything, but for consistency and clarity, using findVaccineByCompanyName is perfectly valid.
 *
 */


/**
 * Can I use var args as one of the parameter?
 *
 * Yes, you can use varargs (variable arguments) as a parameter in Spring Data JPA repository methods, but there are important considerations:
 * For derived query methods (like findByVaccineCompanyIn), you can use varargs: List<vaccinedetails> findByVaccineCompanyIn(String... companies);</vaccinedetails>
 * For @Query methods, varargs are not directly supported for IN clauses. You should use a List or Collection type for parameters in IN clauses:
 * @Query("from VaccineDetails where vaccineCompany IN (:companies)") List<vaccinedetails> searchVaccineByCompanies(@Param("companies") List<string> companies);</string></vaccinedetails>
 * If you use varargs in a custom @Query method, Spring Data JPA will not automatically convert them to a collection for the IN clause, and it may cause errors.
 *
 */


/**
 * non select operation(update, delete, insert) should be transactional
 * transactional: either nothing should happen or entire operation should happen
 * amount removed at one end and amount added at another, then only transaction is said to be compelete
 * select(select ..) operation may or may not be transactional
 *
 * therefore we have to use 2 annotation @Transactional @Modifying
 *
 */

/**
 * sql query vs sql native query
 */