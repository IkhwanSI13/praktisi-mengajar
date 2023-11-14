package com.example.praktisimengajar.network.data.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class Posts implements Serializable {
  private Integer id;

  private String title;

  private String body;

  private Integer userId;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
