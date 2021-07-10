package com.dio.api.service;

import com.dio.api.model.TypeDate;
import com.dio.api.repositories.TypeDateRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeDateService {

    @Autowired
    private TypeDateRepository repository;

    public List<TypeDate> findAll() {
        return repository.findAll();
    }

    public TypeDate findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public TypeDate create(TypeDate obj) {
        return repository.save(obj);
    }

    public TypeDate update (Long id, TypeDate obj) {
        TypeDate oldObj = findById(id);

        oldObj.setDescription(obj.getDescription());
        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
