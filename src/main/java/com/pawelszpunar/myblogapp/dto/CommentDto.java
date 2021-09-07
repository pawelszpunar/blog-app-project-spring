package com.pawelszpunar.myblogapp.dto;

import java.time.LocalDate;

public class CommentDto {

    private String uuid;
    private String content;
    private LocalDate created;
    private String author_uuid;
    private String author;

    public String getUuid() {
        return uuid;
    }

    public CommentDto setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentDto setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CommentDto setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getAuthor_uuid() {
        return author_uuid;
    }

    public CommentDto setAuthor_uuid(String author_uuid) {
        this.author_uuid = author_uuid;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CommentDto setAuthor(String author) {
        this.author = author;
        return this;
    }
}
