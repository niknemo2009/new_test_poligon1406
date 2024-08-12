package com.demoqa.model;

public record User(String firstName, String lastName, String userName, String password) {
    public User(String userName, String password) {
        this(userName, "", userName, password);
    }
}
