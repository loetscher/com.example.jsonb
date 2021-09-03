
package com.example.jsonb.innerclass;

public class LinkExt {
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

  public LinkExt setSelf(String self) {
    this.self = self;
    return this;
  }

  public LinkExt setNext(String next) {
    this.next = next;
    return this;
  }

  public LinkExt setLast(String last) {
    this.last = last;
    return this;
  }
}
