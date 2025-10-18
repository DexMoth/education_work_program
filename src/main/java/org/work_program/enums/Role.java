package org.work_program.enums;

public enum Role {
    TEACHER("Преподаватель"),
    HEAD_OF_DEPARTMENT("Зав. кафедрой"),
    ADMIN("Администратор");

    private String title;

    Role(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
