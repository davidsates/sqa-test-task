package com.david.domain.methods;

import com.david.core.Base;
import com.david.domain.models.Post;

import io.restassured.response.Response;

public class PostMethods extends Base { // Class for Post Methods to interact with the API
    
    // GET /posts
    public static Response getPosts(){ 
        return reqSpec().when().get("/posts");   
    }

    // GET /posts/ {id}
    public static Response getPostById(int id){
        return reqSpec().when().get("/posts/" + id); 
    }

    // GET /posts/ {id} /comments
    public static Response getCommentsFromPostId(int postId){
        return reqSpec().when().get("/posts/" + postId + "/comments"); 
    }

    // GET /comments?postId={id}
    public static Response getCommentsFromPostIdByQueryParam(int postId){
        return reqSpec().queryParam("postId", postId).when().get("/comments"); 
    }

    // POST /posts
    public static Response createPost(Post post){
        return reqSpec().body(post).when().post("/posts"); 
    }  

    // PUT /posts/ {id}
    public static Response updatePost(int id, Post post){
        return reqSpec().body(post).when().put("/posts/" + id); 
    }

    // PATCH /posts/ {id}
    public static Response patchPost(int id, Post post){
        return reqSpec().body(post).when().patch("/posts/" + id); 
    }

    // DELETE /posts/ {id}
    public static Response deletePost(int id){
        return reqSpec().when().delete("/posts/" + id); 
    }

}
