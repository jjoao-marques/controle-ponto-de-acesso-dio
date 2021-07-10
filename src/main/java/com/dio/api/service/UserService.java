package com.dio.api.service;

import com.dio.api.model.User;
import com.dio.api.repositories.UserRepository;
import com.dio.api.service.exceptions.ObjectNotFoundException;
import com.dio.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtils.OBJECT_NOT_FOUND));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User oldObj = findById(id);

        oldObj.setAccessLevel(user.getAccessLevel());
        oldObj.setCompany(user.getCompany());
        oldObj.setDelayTolerance(user.getDelayTolerance());
        oldObj.setName(user.getName());
        oldObj.setUserCategory(user.getUserCategory());
        oldObj.setEndWorkingDay(user.getEndWorkingDay());
        oldObj.setWorkday(user.getWorkday());

        return userRepository.save(oldObj);
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.deleteById(id);
    }
}
