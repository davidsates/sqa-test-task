package com.david.domain.models;

// Class for Comments Data Model (Domain Layer)
public class Comments {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    // Getters and Setters

    public int getPostId(){
        return postId;
    }

    public void setPostId(int postId){
        this.postId = postId;
    }

    public int getId(){
        return id;
    }

    public void setid(int id){
        this.id = id;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }
    
}
