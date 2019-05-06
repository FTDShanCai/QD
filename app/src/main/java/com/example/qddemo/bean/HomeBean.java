package com.example.qddemo.bean;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class HomeBean {

    private HomeEnum homeEnum;
    private String name;
    private int icon;

    public HomeBean(HomeEnum homeEnum, String name, int icon) {
        this.homeEnum = homeEnum;
        this.name = name;
        this.icon = icon;
    }

    public HomeEnum getHomeEnum() {
        return homeEnum;
    }

    public void setHomeEnum(HomeEnum homeEnum) {
        this.homeEnum = homeEnum;
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
