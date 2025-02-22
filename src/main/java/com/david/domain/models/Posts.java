package com.david.domain.models;

//Class for Posts Data Model (Domain Layer)
public class Posts { 

    private int userId;
    private int id;
    private String title;
    private String body;

    //Getters and Setters

    public int getUserId(){
        return userId;
    }

    public void setUserid(int userId){
        this.userId = userId;
    }

    public int getId(){
        return id;
    }

    public void setid(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    
}
