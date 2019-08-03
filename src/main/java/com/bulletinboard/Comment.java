package com.bulletinboard;

public class Comment {
  public int id = 0;
  public String title;
  public String body;
  public String name;

  public Comment(int id, String title, String body, String name) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.name = name;
  }
}
