package com.bulletinboard;

import java.util.ArrayList;
import java.util.HashMap;

import spark.Request;
import spark.Response;

public class CommentHandler {
  public static String getComments(Request req, Response res) {
    ApiResponse apiResponse = new ApiResponse();
    HashMap<String, Object> data = new HashMap<>();

    ArrayList<Comment> comments = new ArrayList<Comment>();
    comments.add(new Comment(1, "title", "body", "name"));
    comments.add(new Comment(2, "title", "body", "name"));
    comments.add(new Comment(3, "title", "body", "name"));
    comments.add(new Comment(4, "title", "body", "name"));
    comments.add(new Comment(5, "title", "body", "name"));
    data.put("comments", comments);

    apiResponse.setStatus("success");
    apiResponse.setData(data);

    res.type("application/json");

    return apiResponse.toJson();
  };
}
