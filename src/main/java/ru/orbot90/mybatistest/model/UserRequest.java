package ru.orbot90.mybatistest.model;

/**
 * Created by orbot on 19.06.16.
 */
public class UserRequest {
    private String id;

    public UserRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
