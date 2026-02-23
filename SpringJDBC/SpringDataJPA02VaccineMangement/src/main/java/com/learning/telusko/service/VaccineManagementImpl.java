package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.dao.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepository repo; //bean will be created by spring

    @Override
    public String registerVaccineDetails(VaccineDetails vaccine) {
        System.out.println("Implementing class of IvaccineRepo is: "+ repo.getClass().getName()); //output : jdk.proxy2.$Proxy105
        VaccineDetails v=repo.save(vaccine);
        return "Vaccine details registered with id : "+v.getId();
    }

    @Override
    public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccines) {
        return repo.saveAll(vaccines);
    }

    @Override
    public long getVaccinesCount() {
        return repo.count();
    }

    @Override
    public boolean checkAvailability(Long id) {
        return repo.existsById(id);
    }

    @Override
    public Iterable<VaccineDetails> getAllVacineInfo() {
        return repo.findAll();
    }

    @Override
    public Iterable<VaccineDetails> getAllVaccineInfoByIds(Iterable<Long> isList) {
        return repo.findAllById(isList);
    }

    @Override
    public Optional<VaccineDetails> getVaccineById(Long id) {
        return repo.findById(id);
    }

    @Override
    public String removeVaccineById(Long id) {
        //check if the vaccine is present and then delete
        Optional<VaccineDetails> optional = repo.findById(id);
        if(optional.isPresent()){
            repo.deleteById(id);  //returns void
            return "Vaccine deleted";
        }
        return "Vaccine record not deleted";


    }

    @Override
    public String removeVaccinesById(List<Long> ids) {
        Iterable<VaccineDetails> list=repo.findAllById(ids);
        int count=ids.size();
        if(count==((List)list).size()){
            repo.deleteAllById(ids);
            return "All Vaccines deleted";
        }
        /**
         * This like transaction, (i.e) delete all or none
         * here for each delete there is a separate query sent.
         */
        return "records are not available with given ids, hence delete is not performed";


        /*repo.deleteAllById(ids);
        AtomicBoolean removedAllVaccine= new AtomicBoolean(false);
        ids.forEach(id->{
            if(checkAvailability(id)) {
                removedAllVaccine.set(true); }
        }); // return in lamba return only the lamba function and not the method hence use flag of atomic type
        if(removedAllVaccine.get()) return "Few Vaccine id not deleted";
        return "All Vaccines deleted";*/
    }

    @Override
    public String removeVaccineObject(VaccineDetails vaccine) {
        Optional<VaccineDetails> vaccineInfo=repo.findById(vaccine.getId());
        if(vaccineInfo.isPresent()) {
            repo.delete(vaccine);
            return "Vaccine record object deleted";
        }
        return "Record not found for deletion";

    }
}

/**
 *  jdk.proxy2.$Proxy105 persistence logic is developed by proxy class
 *
 *  crudReporistory is an interface then who is implmenting those methods, spring is initialising the methos using the proxy class.
 *
 *  In Spring Data JPA, the CrudRepository interface is not implemented by you or your code directly. Instead, Spring Data JPA automatically generates a proxy class at runtime that implements all the methods of CrudRepository for your entity (in this case, VaccineDetails).
 */

/**
 * How does spring know which class to inject to the interface IvaccineRepository? copilot
 *
 */
/**
 * Spring data jps part is creating the pojo, ivaccinerepo interface , ivaccinerepo reference and make function to save method.
 *
 * there we are using main method to call registervaccinedetails method, in spring rest controller will take care of that part
 */