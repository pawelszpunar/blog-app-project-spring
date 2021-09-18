package com.pawelszpunar.myblogapp.service;

import com.pawelszpunar.myblogapp.entity.Role;
import com.pawelszpunar.myblogapp.entity.UserEntity;
import com.pawelszpunar.myblogapp.repository.RoleRepository;
import com.pawelszpunar.myblogapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if(user == null) {
            log.error("User not found in database ({})", username);
            throw new UsernameNotFoundException("User not found in database");
        } else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->
                authorities.add(new SimpleGrantedAuthority(role.getName()))
        );
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public UserEntity saveUser(UserEntity user) {
        log.info("Saving user {} to the database", user.getUsername());

        UserEntity userEntity = new UserEntity()
                .setUuid()
                .setUsername(user.getUsername())
                .setRoles(user.getRoles())
                .setActive(user.getActive())
                .setAvatar(user.getAvatar())
                .setComments(user.getComments());

//        addRoleToUser(user.getUsername(), "ROLE_USER");

        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(userEntity);

//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
    }

    public Role saveRole(Role role) {
        log.info("Saving role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        UserEntity user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    public UserEntity getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    public List<UserEntity> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public UserEntity getSingleUserById(Long id) {
        return userRepository.getById(id);
    }

    public UserEntity getSingleUserByUuid(String uuid) {
        return userRepository.getOneByUuid(uuid);
    }




/*

    public Page<UserEntity> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }



    public UserEntity newUser(UserEntity entity) {
        UserEntity userEntity = new UserEntity()
                .setUsername(entity.getUsername())
                .setPassword(entity.getPassword());
        return userRepository.saveAndFlush(userEntity);
    }*/
}
