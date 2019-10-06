package com.bulletinboard;

public enum ApiStatusResponse {
  SUCCESS("success"),
  ERROR("error");

  final private String status;

  ApiStatusResponse(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return status;
  }
}
