package com.pawelszpunar.myblogapp.dto;

public class UserDto {

    private Long id;
    private String uuid;
    private String username;
    private String password;
    private int active;
    private String roles;
    private String permissions;
    private String avatar;

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UserDto setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getActive() {
        return active;
    }

    public UserDto setActive(int active) {
        this.active = active;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public UserDto setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public String getPermissions() {
        return permissions;
    }

    public UserDto setPermissions(String permissions) {
        this.permissions = permissions;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserDto setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }
}
