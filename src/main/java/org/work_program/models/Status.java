package org.work_program.models;

public enum Status {
    DRAFT("черновик"),
    IN_REVIEW ("на рассмотрении"),
    APPROVED ("одобрен"),
    ARCHIVED ("архивирован");

    private String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}