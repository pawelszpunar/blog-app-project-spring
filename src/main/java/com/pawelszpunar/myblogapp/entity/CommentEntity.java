package com.pawelszpunar.myblogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    @NotEmpty(message = "Content can't be empty")
    private String content;
    private LocalDate created;
    private Long post_id;
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnoreProperties("posts")
    private UserEntity user;

    public CommentEntity setUuid() {
        this.uuid = UUID.randomUUID().toString();
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public CommentEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CommentEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public CommentEntity setGuid(String uuid) {
        this.uuid = UUID.randomUUID().toString();
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentEntity setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CommentEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public PostEntity getPost() {
        return post;
    }

    public CommentEntity setPost(PostEntity post) {
        this.post = post;
        return this;
    }

    public Long getPost_id() {
        return post_id;
    }

    public CommentEntity setPost_id(Long post_id) {
        this.post_id = post_id;
        return this;
    }

    public Long getUser_id() {
        return user_id;
    }

    public CommentEntity setUser_id(Long user_id) {
        this.user_id = user_id;
        return this;
    }
}
