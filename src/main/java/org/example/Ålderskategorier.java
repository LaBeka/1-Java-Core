package org.example;

public class Ålderskategorier {
 private String name;
 private String message;
 private int length;

  public Ålderskategorier(String name, String message, int length) {
    this.name = name;
    this.message = message;
    this.length = length;
  }

  @Override
  public String toString() {
    return "Chat{" +
        "name='" + name + '\'' +
        ", message='" + message + '\'' +
        ", length=" + length +
        '}';
  }
}
