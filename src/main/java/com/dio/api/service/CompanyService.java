package com.dio.api.service;

import com.dio.api.model.Company;
import com.dio.api.repositories.CompanyRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public Company update (Long id, Company obj) {
        Company oldObj = findById(id);


        oldObj.setAddress(obj.getAddress());
        oldObj.setCity(obj.getCity());
        oldObj.setCnpj(obj.getCnpj());
        oldObj.setDescription(obj.getDescription());
        oldObj.setDistrict(obj.getDistrict());
        oldObj.setState(obj.getState());
        oldObj.setTelephone(obj.getTelephone());

        return companyRepository.save(oldObj);
    }

    public void delete(Long id) {
        Company obj = findById(id);
        companyRepository.deleteById(id);
    }
}
