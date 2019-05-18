package com.bulletinboard;

import java.util.HashMap;

import spark.Request;
import spark.Response;

class CommentHandler {
  public static ApiResponse getComments(Request req, Response res) {

    ApiResponse apiResponse = new ApiResponse();
    HashMap<String, Object> data = new HashMap<>();

    apiResponse.setStatus("success");
    apiResponse.setData(data);

    return apiResponse;
  };
}
