package com.pawelszpunar.myblogapp.restControllers;

import com.pawelszpunar.myblogapp.dto.CommentDto;
import com.pawelszpunar.myblogapp.entity.CommentEntity;
import com.pawelszpunar.myblogapp.mapper.CommentMapper;
import com.pawelszpunar.myblogapp.pagination.ListWithMetadata;
import com.pawelszpunar.myblogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ListWithMetadata showComments(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CommentEntity> pageComment = commentService.getAllComments(pageable);

        return new ListWithMetadata(
                CommentMapper.map(pageComment.getContent()),
                pageComment.getTotalPages(),
                pageComment.getTotalElements(),
                pageComment.getNumber(),
                pageComment.getSize()
        );
    }

    @GetMapping("/comment/{id}")
    public CommentDto getSingleComment(@PathVariable Long id){
        return CommentMapper.map(commentService.getSingleCommentById(id));
    }

    @GetMapping("/comment/uuid/{uuid}")
    public CommentDto getSingleCommentByUuid(@PathVariable String uuid) {
        return CommentMapper.map(commentService.getSingleCommentByUuid(uuid));
    }

    @PostMapping("/comment")
    public CommentDto addNewComment(
            @RequestBody CommentEntity commentEntity,
            @RequestParam(required = true, value = "post") Long post_id,
            @RequestParam(
                    required = false,
                    value = "user",
                    defaultValue = "1") Long user_id) {
        return CommentMapper.map(commentService.addComment(commentEntity, post_id, user_id));
    }

    @PostMapping("/comment/post/{uuid}")
    public CommentDto addNewCommentForPostByUuid(
            @RequestBody CommentEntity commentEntity,
            @PathVariable String uuid,
            @RequestParam(required = false, value = "user", defaultValue = "1") Long user_id) {
        return CommentMapper.map(commentService.addNewCommentForPostByUuid(commentEntity, uuid, user_id));
    }


}
