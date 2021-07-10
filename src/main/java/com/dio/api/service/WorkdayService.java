package com.dio.api.service;

import com.dio.api.model.Workday;
import com.dio.api.repositories.WorkdayRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkdayService {

    @Autowired
    private WorkdayRepository workdayRepository;

    public Workday create (Workday workday) {
        return workdayRepository.save(workday);
    }

    public List<Workday> findAll() {
        return workdayRepository.findAll();
    }

    public Workday findById(Long id) {
        return workdayRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    @Transactional
    public Workday update(Long id, Workday obj) {
        Workday oldObj = findById(id);

        oldObj.setDescription(obj.getDescription());
        return workdayRepository.save(oldObj);
    }

    @Transactional
    public void delete(Long id) {
        Workday obj = findById(id);
        workdayRepository.deleteById(id);
    }

}
