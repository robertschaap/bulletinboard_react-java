package com.bulletinboard;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import spark.Request;
import spark.Response;

class CommentModel {
  ArrayList<Comment> comments = new ArrayList<Comment>();
  Integer commentId = 0;

  public CommentModel() {
    this.comments.add(new Comment(++commentId, "title0", "body0", "name0"));
    this.comments.add(new Comment(++commentId, "title1", "body1", "name1"));
    this.comments.add(new Comment(++commentId, "title2", "body2", "name2"));
    this.comments.add(new Comment(++commentId, "title3", "body3", "name3"));
    this.comments.add(new Comment(++commentId, "title4", "body4", "name4"));
    this.comments.add(new Comment(++commentId, "title5", "body5", "name5"));
    this.comments.add(new Comment(++commentId, "title6", "body6", "name6"));
    this.comments.add(new Comment(++commentId, "title7", "body7", "name7"));
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
  }

  public ArrayList<Comment> getComments() {
    return this.comments;
  }
}

public class CommentHandler {
  private static CommentModel model = new CommentModel();

  public static String getComments(Request req, Response res) {
    ApiResponse apiResponse = new ApiResponse();
    HashMap<String, Object> data = new HashMap<>();

    data.put("comments", model.getComments());

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
