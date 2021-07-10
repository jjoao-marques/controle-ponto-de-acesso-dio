package com.dio.api.service;

import com.dio.api.model.Occurrence;
import com.dio.api.repositories.OccurrenceRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccurrenceService {

    @Autowired
    private OccurrenceRepository repository;

    public List<Occurrence> findAll() {
        return repository.findAll();
    }

    public Occurrence findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public Occurrence create(Occurrence obj) {
        return repository.save(obj);
    }

    public Occurrence update (Long id, Occurrence obj) {
        Occurrence oldObj = findById(id);

        oldObj.setDescription(obj.getDescription());
        oldObj.setName(obj.getName());

        return repository.save(oldObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
