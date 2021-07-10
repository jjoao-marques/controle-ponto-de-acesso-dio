package com.dio.api.service;

import com.dio.api.model.Movement;
import com.dio.api.repositories.MovementRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    @Autowired
    private MovementRepository repository;

    public List<Movement> findAll() {
        return repository.findAll();
    }

    public Movement findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public Movement create(Movement obj) {
        return repository.save(obj);
    }

    public Movement update(Long id, Movement obj) {
        Movement oldObj = findById(id);

        oldObj.setCalendario(obj.getCalendario());
        oldObj.setDepartureDate(obj.getDepartureDate());
        oldObj.setEntryDate(obj.getEntryDate());
        oldObj.setOccurrence(obj.getOccurrence());
        oldObj.setTime(obj.getTime());

        return repository.save(oldObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
