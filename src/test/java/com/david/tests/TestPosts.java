package com.david.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.david.domain.methods.PostMethods;
import com.david.domain.models.Post;

import io.restassured.response.Response;

// Class for Post Testing (Test Layer)
public class TestPosts {
    
    /* Test 01: Get all posts
        Expected Results: Status code 200 and the response is not empty.*/
    @Test
    public void testGetPosts(){
        Response response = PostMethods.getPosts();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0);
    }

    /* Test 02: Get a post by a valid id 
        Expected Results: Status code 200. */ 
    @Test
    public void testGetPostById(){
        Response response = PostMethods.getPostById(1);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    /* Test 03: Get a post by a invalid id 
        Expected Results: Status code 404. */ 
    @Test
    public void testGetPostByInvalidId(){
        Response response = PostMethods.getPostById(999);
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    /* Test 04: Validate a post userId by id
        Expected Results: Status code 200 and the response has the correct userId. */ 
    @Test
    public void testGetPostUserId(){
        Response response = PostMethods.getPostById(1);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
    }

    /* Test 05: Validate a post title by id
        Expected Results: Status code 200 and the response has the correct title. */ 
    @Test
    public void testGetPostTitle(){
        Response response = PostMethods.getPostById(1);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    /* Test 06: Validate a post body by id
        Expected Results: Status code 200 and the response has the correct body. */ 
    @Test
    public void testGetPostBody(){
        Response response = PostMethods.getPostById(1);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("body"), "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
    }

    /* Test 07: Create a post with sample data 
        Expected Results: Status code 201 and the response has the correct data.*/ 
    @Test
    public void testCreatePost(){
        Post post = new Post();
        post.setUserid(1);
        post.setTitle("New Title");
        post.setBody("New Body");

        Response response = PostMethods.createPost(post);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
        Assert.assertEquals(response.jsonPath().getString("title"), "New Title");
        Assert.assertEquals(response.jsonPath().getString("body"), "New Body");
    }

    /* Test 08: Update a post by id with sample data 
        Expected Results: Status code 200 and the response has the correct data.*/
    @Test
    public void testUpdatePost(){
        Post post = new Post();
        post.setUserid(2);
        post.setTitle("Updated Title");
        post.setBody("Updated Body");

        Response response = PostMethods.updatePost(1, post);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("userId"), 2);
        Assert.assertEquals(response.jsonPath().getString("title"), "Updated Title");
        Assert.assertEquals(response.jsonPath().getString("body"), "Updated Body");
    }

    /* Test 09: Update a post by an invalid id
        Expected Results: Status code 500.*/
    @Test
    public void testUpdatePostInvalidId(){
        Post post = new Post();
        post.setUserid(2);
        post.setTitle("Updated Title");
        post.setBody("Updated Body");

        Response response = PostMethods.updatePost(999, post);
        Assert.assertEquals(response.getStatusCode(), 500);
    }

    /* Test 10: Patch a post by id updating userId
        Expected Results: Status code 200 and the response has the correct userId.*/
    @Test
    public void testPatchPost(){
        Post post = new Post();
        post.setUserid(50);

        Response response = PostMethods.patchPost(1, post);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("userId"), 50);
    }

    /* Test 11: Delete a post by id
        Expected Results: Status code 200.*/
    @Test
    public void testDeletePost(){
        Response response = PostMethods.deletePost(1);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
