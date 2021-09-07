package com.pawelszpunar.myblogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String username;
    private String password;
    private int active;
    private String roles;
    private String permissions;
    private String avatar;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PostEntity> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CommentEntity> comments;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UserEntity setUuid(String uuid) {
        this.uuid = UUID.randomUUID().toString();
        return this;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public UserEntity setPosts(List<PostEntity> posts) {
        this.posts = posts;
        return this;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public UserEntity setComments(List<CommentEntity> comments) {
        this.comments = comments;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getActive() {
        return active;
    }

    public UserEntity setActive(int active) {
        this.active = active;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public UserEntity setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public String getPermissions() {
        return permissions;
    }

    public UserEntity setPermissions(String permissions) {
        this.permissions = permissions;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserEntity setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }
}
