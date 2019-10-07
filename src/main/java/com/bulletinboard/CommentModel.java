package com.bulletinboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CommentModel {
  List<Comment> comments = new ArrayList<Comment>();
  Integer commentId = 0;

  public CommentModel() {
    this.comments.add(new Comment(commentId, "title0", "body0", "name0"));
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

  public List<Comment> getComments(String sort, Integer offset) {
    List<Comment> sortedComments = sortComments(sort);
    List<Comment> pagedComments = pageComments(sortedComments, offset);
    return pagedComments;
  }

  public List<Comment> sortComments(String sort) {
    if (sort == "desc") {
      return this.comments;
    }

    List<Comment> comments = new ArrayList<Comment>(this.comments);
    Collections.reverse(comments);
    return comments;
  }

  public List<Comment> pageComments(List<Comment> comments, Integer offset) {
    int limit = 4;
    int endIndex = limit + (offset * limit);
    int startIndex = offset * limit;

    if (startIndex > comments.size()) {
      return new ArrayList<Comment>();
    }

    if (endIndex > comments.size()) {
      return comments.subList(startIndex, comments.size());
    }

    return comments.subList(startIndex, endIndex);
  }
}
