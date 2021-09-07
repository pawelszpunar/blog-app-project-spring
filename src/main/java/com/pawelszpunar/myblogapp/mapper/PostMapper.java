package com.pawelszpunar.myblogapp.mapper;

import com.pawelszpunar.myblogapp.dto.PostDto;
import com.pawelszpunar.myblogapp.dto.UserDto;
import com.pawelszpunar.myblogapp.entity.PostEntity;
import com.pawelszpunar.myblogapp.entity.UserEntity;
import com.pawelszpunar.myblogapp.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto map(PostEntity entity) {

        //UserEntity userEntity = entity.getUser();


        return new PostDto()
                .setUuid(entity.getUuid())
                .setTitle(entity.getTitle())
                .setContent(entity.getContent())
                .setCreated(entity.getCreated())
                .setAuthor_uuid(entity.getUser().getUuid())
                .setAuthor(entity.getUser().getUsername())
                //.setAuthor_uuid(entity.getUser().getUuid())
                //.setAuthor(entity.getUser().getUsername())
                .setNumberOfComments((long) entity.getComments().size());
    }

    public static List<PostDto> map(List<PostEntity> entities) {
        return entities
                .stream()
                .map(PostMapper::map)
                .collect(Collectors.toList());
    }
}
