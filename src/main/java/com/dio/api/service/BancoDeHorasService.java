package com.dio.api.service;

import com.dio.api.model.BancoDeHoras;
import com.dio.api.repositories.BancoDeHorasRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoDeHorasService {

    @Autowired
    private BancoDeHorasRepository repository;

    public List<BancoDeHoras> findAll() {
        return repository.findAll();
    }

    public BancoDeHoras findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public BancoDeHoras create(BancoDeHoras obj) {
        return repository.save(obj);
    }

    public BancoDeHoras update (Long id, BancoDeHoras obj) {
        BancoDeHoras oldObj = findById(id);

        oldObj.setDataTrabalhada(obj.getDataTrabalhada());
        oldObj.setHoursBalance(obj.getHoursBalance());
        oldObj.setQuantityHours(obj.getQuantityHours());

        return repository.save(oldObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
