package com.pawelszpunar.myblogapp.restControllers;

import com.pawelszpunar.myblogapp.dto.PostDto;
import com.pawelszpunar.myblogapp.entity.PostEntity;
import com.pawelszpunar.myblogapp.mapper.PostMapper;
import com.pawelszpunar.myblogapp.pagination.ListWithMetadata;
import com.pawelszpunar.myblogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ListWithMetadata getAllPosts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> pagePost = postService.getAllPosts(pageable);

        return new ListWithMetadata(
                PostMapper.map(pagePost.getContent()),
                pagePost.getTotalPages(),
                pagePost.getTotalElements(),
                pagePost.getNumber(),
                pagePost.getSize()
        );
    }

    @GetMapping("/post/{id}")
    public PostDto getSinglePost(@PathVariable long id) {
        return PostMapper.map(postService.getSinglePostById(id));
    }

    @GetMapping("/post/uuid/{uuid}")
    public PostDto getSinglePostByUuid(@PathVariable String uuid) {
        return PostMapper.map(postService.getSinglePostByUuid(uuid));
    }

    @PostMapping(value = "/admin/post")
    public PostDto createNewPost(
            @RequestBody PostEntity postEntity,
            @RequestParam(required = false, value = "user", defaultValue = "1") Long user_id) {
        PostEntity entity = postService.newPost(postEntity,user_id);
        return PostMapper.map(entity);
    }

    @DeleteMapping("/admin/post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
     }

     @DeleteMapping("/admin/post/uuid/{uuid}")
    public void deletePostByUuid(@PathVariable String uuid) {
        postService.removeByUuid(uuid);
     }

     // todo hide post instead of delete
}
