package com.pawelszpunar.myblogapp.service;

import com.pawelszpunar.myblogapp.entity.UserEntity;
import com.pawelszpunar.myblogapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<UserEntity> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public UserEntity getSingleUserById(Long id) {
        return userRepository.getById(id);
    }

    public UserEntity getSingleUserByUuid(String uuid) {
        return userRepository.getOneByUuid(uuid);
    }

    public UserEntity newUser(UserEntity entity) {
        UserEntity userEntity = new UserEntity()
                .setUsername(entity.getUsername())
                .setPassword(entity.getPassword());
        return userRepository.saveAndFlush(userEntity);
    }
}
