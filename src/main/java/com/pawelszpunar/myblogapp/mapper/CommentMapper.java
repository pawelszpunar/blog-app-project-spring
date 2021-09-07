package com.pawelszpunar.myblogapp.mapper;

import com.pawelszpunar.myblogapp.dto.CommentDto;
import com.pawelszpunar.myblogapp.entity.CommentEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommentMapper {

    public static CommentDto map(CommentEntity entity) {
        return new CommentDto()
                .setUuid(entity.getUuid())
                .setContent(entity.getContent())
                .setCreated(entity.getCreated())
                .setAuthor_uuid(entity.getUser().getUuid())
                .setAuthor(entity.getUser().getUsername());
    }

    public static List<CommentDto> map(List<CommentEntity> entity) {
        return entity
                .stream()
                .map(CommentMapper::map)
                .collect(Collectors.toList());
    }
}
