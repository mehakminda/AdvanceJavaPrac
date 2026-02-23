package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.dao.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepository repo; //bean will be created by spring


    @Override
    public Iterable<VaccineDetails> fetchDetails(boolean status, String... properties) { // ... is called var args, it means any number of string type objects can be passed as arguments
        System.out.println("Implementing class of SortingandPagingRepository interface injected by spring is: "+repo.getClass().getName()); //jdk.proxy2.$Proxy105
        Sort sort=Sort.by(status? Sort.Direction.ASC: Sort.Direction.DESC, properties);
        //ASC and DSC are enums of Direction class
        // if status is true then sort in asc order if false then sort in desc order.
        //by is the static method of sort clas and return Sort object
        return repo.findAll(sort);
    }

    @Override
    public Page<VaccineDetails> fetchDataByPageNo(int pageNo, int pageSize, boolean status, String... properties) {
        PageRequest pageRequest=PageRequest.of(pageNo,pageSize,status? Sort.Direction.ASC: Sort.Direction.DESC,properties); //adding sorting is option, we can just get the record in multiple pages


        return repo.findAll(pageRequest);
    }

    @Override
    public void fetchdetailsByPagination(int pageSize) {
        Page<VaccineDetails> vaccineDetailsIterable= repo.findAll(PageRequest.ofSize(pageSize));
        System.out.println("Total pages is : "+vaccineDetailsIterable.getTotalElements());
        int pageCount=vaccineDetailsIterable.getTotalPages();
        for(int i=0; i<vaccineDetailsIterable.getTotalPages();i++){
            Page<VaccineDetails> pageIterable= repo.findAll(PageRequest.of(i,pageSize));
            System.out.println("Page No: "+i);
            pageIterable.forEach(data -> System.out.println(data.getVaccineName()+" -> "+data.getVaccineCompany()) );

        }

        //need to understand more
    }
}

/**
 *  jdk.proxy2.$Proxy105 persistence logic is developed by proxy class
 */

/**
 * Spring data jps part is creating the pojo, ivaccinerepo interface , ivaccinerepo reference and make function to save method.
 *
 * there we are using main method to call registervaccinedetails method, in spring rest controller will take care of that part
 */