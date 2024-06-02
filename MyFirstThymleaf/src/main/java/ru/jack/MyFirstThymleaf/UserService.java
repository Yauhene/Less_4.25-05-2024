package ru.jack.MyFirstThymleaf;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        userRepository.save(new User(null, "Евгений", "jacck@tut.by"));
        userRepository.save(new User(null, "John", "john@tam.gde"));
        userRepository.save(new User(null, "Хрюндель", "Naf-Naf@hru.by"));
       return userRepository.findAll();
    }

    public User getUserByID(Long id) {
        return userRepository.findById(id);
    }
}
