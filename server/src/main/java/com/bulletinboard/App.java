package com.bulletinboard;

import static spark.Spark.*;

public class App {
  public static void main( String[] args ) {
      int port = 4567;
      port(port);
      System.out.println("Running on http://localhost:" + port);
      get("/", (req, res) -> "Hello World!");
  }
}
