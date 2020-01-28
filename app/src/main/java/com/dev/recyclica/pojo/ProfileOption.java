package com.dev.recyclica.pojo;

public class ProfileOption {
    private String name;
    private String description;
    private boolean isActivate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProfileOption(String name, String description, boolean isActivate) {
        this.name = name;
        this.description = description;
        this.isActivate = isActivate;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }
}
