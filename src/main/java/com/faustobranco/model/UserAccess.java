package com.faustobranco.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UserAccess {
    private String id;
    private String name;
    private String login;
    private String area;
    private List lstUses ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, HashSet<String>> getUses(int Index) {
        return (HashMap<String, HashSet<String>>) lstUses.get(Index);
    }

    public void setUses(List lstUses) {
        this.lstUses = lstUses;
    }

    @Override
    public String toString() {
        return "UserAccess{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", area='" + area + '\'' +
                ", lstUses=" + lstUses +
                '}';
    }
}