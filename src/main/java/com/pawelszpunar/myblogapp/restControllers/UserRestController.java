package com.pawelszpunar.myblogapp.restControllers;

import com.pawelszpunar.myblogapp.dto.UserDto;
import com.pawelszpunar.myblogapp.entity.UserEntity;
import com.pawelszpunar.myblogapp.mapper.UserMapper;
import com.pawelszpunar.myblogapp.pagination.ListWithMetadata;
import com.pawelszpunar.myblogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    private ListWithMetadata getAllUsers(
            @RequestParam(required = false, value = "page", defaultValue = "0") int page,
            @RequestParam(required = false, value = "size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> pageUser = userService.getAllUsers(pageable);

        return new ListWithMetadata(
                UserMapper.map(pageUser.getContent()),
                pageUser.getTotalPages(),
                pageUser.getTotalElements(),
                pageUser.getNumber(),
                pageUser.getSize()
        );
    }

    @GetMapping("/admin/user/{id}")
    public UserDto getSingleUserById(@PathVariable long id) {
        return UserMapper.map(userService.getSingleUserById(id));
    }

}
