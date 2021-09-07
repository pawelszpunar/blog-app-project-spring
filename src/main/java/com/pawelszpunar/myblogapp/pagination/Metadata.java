package com.pawelszpunar.myblogapp.pagination;

public class Metadata {

    private final int totalPages;
    private final long totalElements;
    private final int page;
    private final int size;

    public Metadata(int totalPages, long totalElements, int page, int size) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.page = page;
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
