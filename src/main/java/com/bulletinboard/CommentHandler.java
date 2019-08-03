package com.bulletinboard;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

  public static String postComments(Request req, Response res) {
    res.type("application/json");

    ApiResponse apiResponse = new ApiResponse();
    Type type = new TypeToken<Map<String, String>>(){}.getType();
    Map<String, String> map = new Gson().fromJson(req.body(), type);

    if (map.containsKey("title") && map.containsKey("body") && map.containsKey("name")) {
      apiResponse.setStatus("success");
      return apiResponse.toJson();
    }

    apiResponse.setStatus("error");
    apiResponse.setMessage("error");
    return apiResponse.toJson();
  }
}
