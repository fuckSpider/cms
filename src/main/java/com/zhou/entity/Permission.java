package com.zhou.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private String id;
    private String url;
    private String permission;
    private Integer roleid;
    private String description;
    private String avaliable;
    private String pid;
    private String field1;

    public Permission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", roleid=" + roleid +
                ", description='" + description + '\'' +
                ", avaliable='" + avaliable + '\'' +
                ", pid='" + pid + '\'' +
                ", field1='" + field1 + '\'' +
                '}';
    }
}
