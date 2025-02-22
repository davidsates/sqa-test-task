package com.david.domain.methods;

import com.david.core.Base;
import com.david.domain.models.Posts;

import io.restassured.response.Response;

// Class for API Methods
public class APIMethods extends Base {
    
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
    public static Response createPost(Posts post){
        return reqSpec().body(post).when().post("/posts"); 
    }  

    // PUT /posts/ {id}
    public static Response updatePost(int id, Posts post){
        return reqSpec().body(post).when().put("/posts/" + id); 
    }

    // PATCH /posts/ {id}
    public static Response patchPost(int id, Posts post){
        return reqSpec().body(post).when().patch("/posts/" + id); 
    }

    // DELETE /posts/ {id}
    public static Response deletePost(int id){
        return reqSpec().when().delete("/posts/" + id); 
    }

}
