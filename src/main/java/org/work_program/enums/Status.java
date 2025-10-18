package org.work_program.enums;

public enum Status {
    DRAFT("Черновик"),
    IN_REVIEW ("На рассмотрении"),
    APPROVED ("Одобрен"),
    ARCHIVED ("Архивирован");

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