package com.pawelszpunar.myblogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "posts")
@JsonIgnoreProperties("comments")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    @NotEmpty(message = "Title can't be empty")
    private String title;
    @NotEmpty(message = "Content can't be empty")
    private String content;
    private LocalDate created;
    private Long user_id;
    @Column(columnDefinition = "integer default 0")
    private int hidden;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CommentEntity> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public PostEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public PostEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public PostEntity setUuid(String uuid) {
        this.uuid = UUID.randomUUID().toString();
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostEntity setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public PostEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public PostEntity setComments(List<CommentEntity> comments) {
        this.comments = comments;
        return this;
    }

    public Long getUser_id() {
        return user_id;
    }

    public PostEntity setUser_id(Long user_id) {
        this.user_id = user_id;
        return this;
    }

    public int getHidden() {
        return hidden;
    }

    public PostEntity setHidden(int hidden) {
        this.hidden = hidden;
        return this;
    }
}
