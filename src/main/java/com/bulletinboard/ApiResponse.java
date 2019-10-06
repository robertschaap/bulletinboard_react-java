package com.bulletinboard;

import java.util.HashMap;

import com.google.gson.Gson;

public class ApiResponse {
  public ApiStatusResponse status = null;
  public String message = "";
  public HashMap<String, Object> data;

  public void setData(HashMap<String, Object> data) {
    this.data = data;
  }

  public void setStatus(ApiStatusResponse status) {
    this.status = status;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String toJson() {
    return new Gson().toJson(this);
  }
}
