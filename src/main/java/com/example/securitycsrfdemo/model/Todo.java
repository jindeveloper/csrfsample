package com.example.securitycsrfdemo.model;

public class Todo {

    public Todo(){

    }
    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Todo(String title) {
        this.title = title;
    }
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
