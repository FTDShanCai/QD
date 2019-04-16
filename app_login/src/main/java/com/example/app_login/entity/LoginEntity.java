package com.example.app_login.entity;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class LoginEntity {
    private String courseId;
    private String id;
    private String name;
    private String order;
    private String parentChapterId;
    private String userControlSetTop;
    private String visible;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(String parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public String getUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(String userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }
}
