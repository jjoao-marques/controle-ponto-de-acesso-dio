package com.dio.api.service;

import com.dio.api.model.UserCategory;
import com.dio.api.repositories.UserCategoryRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class UserCategoryService {

    @Autowired
    private UserCategoryRepository repository;


    public List<UserCategory> findAll() {
        return repository.findAll();
    }

    public UserCategory findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public UserCategory create(UserCategory obj) {
        return repository.save(obj);
    }

    public UserCategory update (Long id, UserCategory obj) {
        UserCategory oldObj = findById(id);

        oldObj.setDescription(obj.getDescription());
        return repository.save(oldObj);
    }

    public void delete(Long id) {
        UserCategory obj = findById(id);
        repository.deleteById(id);
    }
}
