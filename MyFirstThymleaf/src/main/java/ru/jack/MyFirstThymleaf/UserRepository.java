package ru.jack.MyFirstThymleaf;

import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

@Component
public class UserRepository {
    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }
}
