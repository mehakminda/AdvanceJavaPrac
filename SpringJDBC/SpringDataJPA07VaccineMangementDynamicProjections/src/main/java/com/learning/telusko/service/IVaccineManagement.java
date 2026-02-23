package com.learning.telusko.service;

import com.learning.telusko.View;

import java.util.List;

public interface IVaccineManagement {

    public <T extends View>List<T> searchByVaccineCompany(String companyname, Class<T> cls);
}
