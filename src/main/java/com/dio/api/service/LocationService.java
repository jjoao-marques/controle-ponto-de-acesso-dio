package com.dio.api.service;

import com.dio.api.model.Location;
import com.dio.api.repositories.LocationRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    public List<Location> findAll() {
        return repository.findAll();
    }

    public Location findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public Location create(Location obj) {
        return repository.save(obj);
    }

    public Location update (Long id, Location obj) {
        Location oldObj = findById(id);

        oldObj.setDescription(obj.getDescription());
        oldObj.setAccessLevel(obj.getAccessLevel());

        return  repository.save(oldObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
