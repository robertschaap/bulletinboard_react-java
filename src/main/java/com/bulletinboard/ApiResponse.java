package com.bulletinboard;

import java.util.HashMap;

import com.google.gson.Gson;

public class ApiResponse {
  public String status = null;
  public String message = "";
  public HashMap<String, Object> data;

  public ApiResponse(ApiStatusResponse status, HashMap<String, Object> data) {
    this.status = status.toString();
    this.data = data;
  }

  public ApiResponse(ApiStatusResponse status, String message) {
    this.status = status.toString();
    this.message = message;
  }

  public String toJson() {
    return new Gson().toJson(this);
  }
}
