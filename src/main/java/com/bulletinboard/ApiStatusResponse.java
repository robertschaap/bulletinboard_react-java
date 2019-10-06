package com.bulletinboard;

public enum ApiStatusResponse {
  SUCCESS("success"),
  ERROR("error");

  final private String status;

  ApiStatusResponse(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
