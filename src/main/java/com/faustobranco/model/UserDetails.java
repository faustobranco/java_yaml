package com.faustobranco.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    private String id;
    private String name;
    private String login;
    private String area;
    private List lstUses ;

    @JsonCreator
    public UserDetails(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("login") String login, @JsonProperty("area") String area, @JsonProperty("uses") List lstUses) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.area = area;
        this.lstUses = lstUses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getArea() {
        return area;
    }

    public HashMap<String, HashSet<String>> getUses(int Index) {
        return (HashMap<String, HashSet<String>>) lstUses.get(Index);
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", area='" + area + '\'' +
                ", lstUses=" + lstUses +
                '}';
    }
}
