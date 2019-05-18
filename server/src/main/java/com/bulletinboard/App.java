package com.bulletinboard;

import static spark.Spark.*;

public class App {
  private static Integer port = 4567;

  public static void main( String[] args ) {
      port(port);
      System.out.println("Running on http://localhost:" + port);

      get("/api/comments", CommentHandler::getComments);
  }
}
