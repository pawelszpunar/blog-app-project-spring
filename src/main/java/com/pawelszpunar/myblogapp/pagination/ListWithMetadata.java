package com.pawelszpunar.myblogapp.pagination;

import java.util.List;

public class ListWithMetadata<T> {
    private final Metadata metadata;
    private final List<T> content;


    public ListWithMetadata(List<T> content, int totalPages, long totalElements, int page, int size) {
        this.metadata = new Metadata(totalPages, totalElements, page, size);
        this.content = content;
    }

    public List<T> getContent() {
        return content;
    }

    public Metadata getMetadata() {
        return metadata;
    }
}
