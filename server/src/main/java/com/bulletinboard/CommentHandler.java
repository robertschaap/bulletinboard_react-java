package com.bulletinboard;

import java.util.HashMap;

import spark.Request;
import spark.Response;

public class CommentHandler {
  public static String getComments(Request req, Response res) {
    ApiResponse apiResponse = new ApiResponse();
    HashMap<String, Object> data = new HashMap<>();

    apiResponse.setStatus("success");
    apiResponse.setData(data);

    return apiResponse.toJson();
  };
}
