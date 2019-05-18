package com.bulletinboard;

import java.util.HashMap;

class ApiResponse {
  HashMap<String, Object> data;
  String status;
  String message;

  public void setData(HashMap<String, Object> data) {
    this.data = data;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
