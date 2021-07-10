package com.dio.api.service;

import com.dio.api.model.AccessLevel;
import com.dio.api.repositories.AccessLevelRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessLevelService {

    @Autowired
    private AccessLevelRepository repository;

    public List<AccessLevel> findAll() {
        return repository.findAll();
    }

    public AccessLevel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public AccessLevel create(AccessLevel obj) {
        return repository.save(obj);
    }

    public AccessLevel update (Long id, AccessLevel obj) {
        AccessLevel oldObj = findById(id);

        oldObj.setDescription(obj.getDescription());
        return repository.save(oldObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
