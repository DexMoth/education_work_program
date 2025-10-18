package org.work_program.enums;

public enum StudyForm {
    FULL_TIME("Очная"),
    PART_TIME("Очно-заочная"),
    CORRESPONDENCE ("Заочная");

    private String title;

    StudyForm(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
