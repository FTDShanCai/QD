package com.example.qddemo.bean;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class StudyBean {

    private StudyEnum studyEnum;
    private String name;
    private int icon;

    public StudyBean(StudyEnum studyEnum, String name, int icon) {
        this.studyEnum = studyEnum;
        this.name = name;
        this.icon = icon;
    }

    public StudyEnum getStudyEnum() {
        return studyEnum;
    }

    public void setStudyEnum(StudyEnum studyEnum) {
        this.studyEnum = studyEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
