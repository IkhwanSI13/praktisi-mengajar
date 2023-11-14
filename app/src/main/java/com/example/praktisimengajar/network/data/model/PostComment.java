package com.example.praktisimengajar.network.data.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class PostComment implements Serializable {
  private String name;

  private Integer postId;

  private Integer id;

  private String body;

  private String email;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPostId() {
    return this.postId;
  }

  public void setPostId(Integer postId) {
    this.postId = postId;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
