package com.david.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.david.domain.methods.PostMethods;

import io.restassured.response.Response;

// Class for Comments Test (Test Layer)
public class TestComments {   
    
    /* Test 01: Get all comments for a valid post id
        Expected Results: Status code 200 and the response is not empty.*/
    @Test
    public void testGetCommentsFromPost(){
        Response comments = PostMethods.getCommentsFromPostId(1);
        Assert.assertEquals(comments.getStatusCode(), 200);
        Assert.assertTrue(comments.jsonPath().getList("$").size() > 0);
    }

    /* Test 02: all comments from a valid post id by query params 
        Expected Results: Status code 200 and the response is not empty.*/
    @Test
    public void testGetCommentsFromPostByQueryParam(){
        Response comments = PostMethods.getCommentsFromPostIdByQueryParam(1);
        Assert.assertEquals(comments.getStatusCode(), 200);
        Assert.assertTrue(comments.jsonPath().getList("$").size() > 0);
    }

    /* Test 03: Get all comments from a invalid post id
        Expected Results: The response is empty.*/
    @Test
    public void testGetCommentsFromPostByQueryParamInvalidId(){
        Response comments = PostMethods.getCommentsFromPostIdByQueryParam(9999);
        Assert.assertTrue(comments.jsonPath().getList("$").isEmpty());
    }

    /* Test 04: Validate name of comment by post id
        Expected Results: The status code is 200 and the response has the correct name.*/
    @Test
    public void testGetCommentNameByPostId(){
        Response comments = PostMethods.getCommentsFromPostId(1);
        Assert.assertEquals(comments.getStatusCode(), 200);

        String name = comments.jsonPath().getString("[0].name");
        Assert.assertEquals(name, "id labore ex et quam laborum");
    }

    /* Test 05: Validate email of comment by post id
        Expected Results: The status code is 200 and the response has the correct email.*/
    @Test
    public void testGetCommentEmailByPostId(){
        Response comments = PostMethods.getCommentsFromPostId(1);
        Assert.assertEquals(comments.getStatusCode(), 200);

        String email = comments.jsonPath().getString("[0].email");
        Assert.assertEquals(email, "Eliseo@gardner.biz");
    }

    /* Test 06: Validate body of comment by post id
        Expected Results: The status code is 200 and the response has the correct body.*/
    @Test
    public void testGetCommentBodyByPostId(){
        Response comments = PostMethods.getCommentsFromPostId(1);
        Assert.assertEquals(comments.getStatusCode(), 200);

        String body = comments.jsonPath().getString("[0].body");
        Assert.assertEquals(body, "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium");
    }


}
