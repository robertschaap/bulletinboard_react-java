package com.bulletinboard;

import java.util.ArrayList;

class CommentModel {
  ArrayList<Comment> comments = new ArrayList<Comment>();
  Integer commentId = 0;

  public CommentModel() {
    this.comments.add(new Comment(++commentId, "title0", "body0", "name0"));
    this.comments.add(new Comment(++commentId, "title1", "body1", "name1"));
    this.comments.add(new Comment(++commentId, "title2", "body2", "name2"));
    this.comments.add(new Comment(++commentId, "title3", "body3", "name3"));
    this.comments.add(new Comment(++commentId, "title4", "body4", "name4"));
    this.comments.add(new Comment(++commentId, "title5", "body5", "name5"));
    this.comments.add(new Comment(++commentId, "title6", "body6", "name6"));
    this.comments.add(new Comment(++commentId, "title7", "body7", "name7"));
  }

  public void addComment(String title, String body, String name) throws IllegalArgumentException {
    if (title == null || body == null || name == null) {
      throw new IllegalArgumentException("None of the arguments must be null");
    }
    this.comments.add(new Comment(++commentId, title, body, name));
  }

  public ArrayList<Comment> getComments() {
    return this.comments;
  }
}
