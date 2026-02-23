package com.learning.telusko.service;

import com.learning.telusko.View;
import com.learning.telusko.dao.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepository repo; //bean will be created by spring


    @Override
    public <T extends View> List<T> searchByVaccineCompany(String companyname, Class<T> cls) {
        return repo.findByVaccineCompany(companyname,cls);
    }
}
