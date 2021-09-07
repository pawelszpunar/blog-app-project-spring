package com.pawelszpunar.myblogapp.dto;

public class UserDtoSimple {

    private String uuid;
    private String username;
    private String avatar;

    public String getUuid() {
        return uuid;
    }

    public UserDtoSimple setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDtoSimple setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserDtoSimple setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }
}
