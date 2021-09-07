package com.pawelszpunar.myblogapp.dto;

import java.time.LocalDate;

public class PostDto {

    private String uuid;
    private String title;
    private String content;
    private LocalDate created;
    private String author;
    private String author_uuid;
    private Long numberOfComments;

    public String getUuid() {
        return uuid;
    }

    public PostDto setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostDto setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public PostDto setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public PostDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getAuthor_uuid() {
        return author_uuid;
    }

    public PostDto setAuthor_uuid(String author_uuid) {
        this.author_uuid = author_uuid;
        return this;
    }

    public Long getNumberOfComments() {
        return numberOfComments;
    }

    public PostDto setNumberOfComments(Long numberOfComments) {
        this.numberOfComments = numberOfComments;
        return this;
    }
}
