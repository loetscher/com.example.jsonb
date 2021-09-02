
package com.example.jsonb;

public class JsonApiDto {
  private Links linksObject;

  public JsonApiDto(Links linksObject) {
    this.linksObject = linksObject;
  }

  // Getter Methods

  public Links getLinks() {
    return linksObject;
  }

  // Setter Methods
  public void setLinks(Links linksObject) {
    this.linksObject = linksObject;
  }
}

class Links {
  private String self;
  private String next;
  private String last;

  // Getter Methods

  public String getSelf() {
    return self;
  }

  public String getNext() {
    return next;
  }

  public String getLast() {
    return last;
  }

  // Setter Methods

  public Links setSelf(String self) {
    this.self = self;
    return this;
  }

  public Links setNext(String next) {
    this.next = next;
    return this;
  }

  public Links setLast(String last) {
    this.last = last;
    return this;
  }
}