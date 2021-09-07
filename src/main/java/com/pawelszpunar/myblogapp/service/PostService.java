package com.pawelszpunar.myblogapp.service;

import com.pawelszpunar.myblogapp.entity.CommentEntity;
import com.pawelszpunar.myblogapp.entity.PostEntity;
import com.pawelszpunar.myblogapp.entity.UserEntity;
import com.pawelszpunar.myblogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public Page<PostEntity> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public PostEntity getSinglePostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public PostEntity getSinglePostByUuid(String uuid) {
        return postRepository.getOneByUuid(uuid);
    }

    public PostEntity newPost(PostEntity entity, Long id) {

        PostEntity postEntity = new PostEntity()
                .setTitle(entity.getTitle())
                .setContent(entity.getContent())
                .setUuid(UUID.randomUUID().toString())
                .setUser_id(id)
                .setUser(userService.getSingleUserById(id));

        if(entity.getCreated() == null) {
            postEntity.setCreated(LocalDate.now());
        } else {
            postEntity.setCreated(entity.getCreated());
        }
        /*if(userService.getSingleUserById(id) == null) {
            postEntity.setUser(new UserEntity());
        } else {
            postEntity.setUser(userService.getSingleUserById(id))
            .setUser_id(id);
        }*/

        return postRepository.saveAndFlush(postEntity);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public void removeByUuid(String uuid) {
        postRepository.deleteById(getSinglePostByUuid(uuid).getId());
    }



}
