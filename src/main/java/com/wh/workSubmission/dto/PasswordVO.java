package com.wh.workSubmission.dto;

public class PasswordVO {
    private String id;
    private String type;
    private String oldPassword;
    private String newPassword;

    public PasswordVO() {
    }

    public PasswordVO(String id, String type, String oldPassword, String newPassword) {
        this.id = id;
        this.type = type;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "PasswordVO{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
