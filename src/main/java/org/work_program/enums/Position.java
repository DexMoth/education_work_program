package org.work_program.enums;

public enum Position {
    ASSISTANT("Ассистент"),
    TEACHER("Преподаватель"),
    SENIOR_TEACHER("Старший преподаватель"),
    DOCENT("Доцент"),
    PROFESSOR("Профессор");

    private String title;

    Position(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
