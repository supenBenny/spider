package me.fb.spider.module.user.service;

import me.fb.spider.module.user.domain.User;
import me.fb.spider.module.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getNameById(Long id) {
        return userRepository.getNameById(id);
    }
}
