package com.bulletinboard;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import spark.Request;
import spark.Response;

public class CommentHandler {
  private static CommentModel model = new CommentModel();

  public static String getComments(Request req, Response res) {
    res.type("application/json");

    HashMap<String, Object> data = new HashMap<>();
    data.put("comments", model.getComments());

    return new ApiResponse(ApiStatusResponse.SUCCESS, data).toJson();
  };

  public static String postComments(Request req, Response res) {
    res.type("application/json");

    Type type = new TypeToken<Map<String, String>>(){}.getType();
    Map<String, String> map = new Gson().fromJson(req.body(), type);

    try {
      model.addComment(map.get("title"), map.get("body"), map.get("name"));
      return new ApiResponse(ApiStatusResponse.SUCCESS, "message").toJson();
    } catch (IllegalArgumentException exception) {
      System.out.println(exception);
      return new ApiResponse(ApiStatusResponse.ERROR, "error").toJson();
    }
  }
}
