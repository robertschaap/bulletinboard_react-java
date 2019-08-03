package com.bulletinboard;

import java.util.HashMap;

import com.google.gson.Gson;

public class ApiResponse {
  String status = "";
  String message = "";
  HashMap<String, Object> data;

  public void setData(HashMap<String, Object> data) {
    this.data = data;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String toJson() {
    return new Gson().toJson(this);
  }
}
