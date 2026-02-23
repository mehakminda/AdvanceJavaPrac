package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.dao.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepository repo; //bean will be created by spring

    @Override
    public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccineDetails, boolean status, String... properties) {
        Example<VaccineDetails> example=Example.of(vaccineDetails);
        Sort sort=Sort.by(status? Sort.Direction.ASC: Sort.Direction.DESC,properties);
        return  repo.findAll(example,sort);
    }

    @Override
    public List<VaccineDetails> searchVaccineByGivenObject(VaccineDetails vaccine) {
        Example<VaccineDetails> example = Example.of(vaccine);
        return repo.findAll(example);

    }

    @Override
    public VaccineDetails searchVaccineById(Long id) {
        return repo.getById(id);
    }

    @Override
    public String removeVaccineByIds(Iterable<Long> ids) {
        List<VaccineDetails> list = repo.findAllById(ids);
        if (!list.isEmpty()) {
            // Get list of vaccine IDs : from List<VaccineDetails>list , how can i get list of vaccine ids
            List<Long> vaccineIds = list.stream()
                .map(VaccineDetails::getId)
                .collect(java.util.stream.Collectors.toList());
            // Example: delete all by IDs
            repo.deleteAllByIdInBatch(vaccineIds);
            /**
             * if any of the id is present delete
             * happens in a batch ie single shot in 1 query
             *
             * in contrary to deleteAllById of crudrepository
             */
            return "Deleted " + vaccineIds.size() + " vaccines.";
        }
        return "No vaccines found for given IDs.";
    }
}
