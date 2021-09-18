package com.pawelszpunar.myblogapp.mapper;

import com.pawelszpunar.myblogapp.dto.UserDto;
import com.pawelszpunar.myblogapp.dto.UserDtoSimple;
import com.pawelszpunar.myblogapp.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

/*    public static UserDto map(UserEntity user) {
        return new UserDto()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setActive(user.getActive())
                .setRoles(user.getRoles())
                .setPermissions(user.getPermissions())
                .setUuid(user.getUuid())
                .setAvatar(user.getAvatar());
    }

    public static UserDtoSimple mapUuidAndUsername(UserEntity user) {
        if(user == null) {
            return new UserDtoSimple();
        }
        return new UserDtoSimple()
                .setUuid(user.getUuid())
                .setUsername(user.getUsername())
                .setAvatar(user.getAvatar());
    }

    public static List<UserDto> map(List<UserEntity> user) {
        return user
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

    public static List<UserDtoSimple> mapUuidAndUsername(List<UserEntity> user) {
        return user
                .stream()
                .map(UserMapper::mapUuidAndUsername)
                .collect(Collectors.toList());
    }*/
}
