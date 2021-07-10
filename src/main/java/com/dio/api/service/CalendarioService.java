package com.dio.api.service;

import com.dio.api.model.Calendario;
import com.dio.api.repositories.CalendarioRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioService {

    @Autowired
    private CalendarioRepository calendarioRepository;

    public List<Calendario> findAll() {
        return calendarioRepository.findAll();
    }

    public Calendario findById(Long id) {
        return calendarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public Calendario create(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public Calendario update (Long id, Calendario obj) {
        Calendario oldObj = findById(id);

        oldObj.setDescription(obj.getDescription());
        oldObj.setSpecialDate(obj.getSpecialDate());
        oldObj.setTypeDate(obj.getTypeDate());

        return calendarioRepository.save(oldObj);
    }


    public void delete(Long id) {
        Calendario obj = findById(id);
        calendarioRepository.deleteById(id);
    }
}
