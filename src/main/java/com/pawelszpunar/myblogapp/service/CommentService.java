package com.pawelszpunar.myblogapp.service;

import com.pawelszpunar.myblogapp.dto.CommentDto;
import com.pawelszpunar.myblogapp.entity.CommentEntity;
import com.pawelszpunar.myblogapp.entity.UserEntity;
import com.pawelszpunar.myblogapp.repository.CommentRepository;
import com.pawelszpunar.myblogapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    public Page<CommentEntity> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    public CommentEntity getSingleCommentByUuid(String uuid) {
        return commentRepository.getOneByUuid(uuid);
    }

    public CommentEntity getSingleCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow();
    }

    public CommentEntity addComment(CommentEntity entity, Long post_id, Long user_id) {
        CommentEntity commentEntity = new CommentEntity()
                .setContent(entity.getContent())
                .setPost_id(post_id)
                .setUuid();
        if(entity.getCreated() == null) {
            commentEntity.setCreated(LocalDate.now());
        } else {
            commentEntity.setCreated(entity.getCreated());
        }
        if(userService.getSingleUserById(user_id) == null) {
            commentEntity.setUser(new UserEntity());
        } else {
            commentEntity.setUser(userService.getSingleUserById(user_id))
                    .setUser_id(user_id);
        }
        return commentRepository.saveAndFlush(commentEntity);
    }

    public CommentEntity addNewCommentForPostByUuid(CommentEntity entity, String uuid, Long user_id) {
        CommentEntity commentEntity = new CommentEntity()
                .setUuid()
                .setContent(entity.getContent())
                .setPost_id(postService.getSinglePostByUuid(uuid).getId())
                .setUser_id(user_id)
                .setUser(userService.getSingleUserById(user_id));

        if(entity.getCreated() == null) {
            commentEntity.setCreated(LocalDate.now());
        } else {
            commentEntity.setCreated(entity.getCreated());
        }
        return commentRepository.saveAndFlush(commentEntity);

    }

}
