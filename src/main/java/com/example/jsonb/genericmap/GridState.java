
package com.example.jsonb.genericmap;

import java.util.ArrayList;
import java.util.List;

public class GridState {
  private List<Integer> selection;
  private int cursorColumn;
  private int vScroll;
  private int expandSize;
  private Boolean maximized;

  public List<Integer> getSelection() {
    if (selection == null) {
      this.selection = new ArrayList<>();
    }
    return selection;
  }

  public void setSelection(List<Integer> newSelection) {
    if (selection == null) {
      this.selection = new ArrayList<>();
    }
    this.selection.clear();
    this.selection.addAll(newSelection);
  }

  public int getCursorColumn() {
    return cursorColumn;
  }

  public void setCursorColumn(int cursorColumn) {
    this.cursorColumn = cursorColumn;
  }

  public int getvScroll() {
    return vScroll;
  }

  public void setvScroll(int vScroll) {
    this.vScroll = vScroll;
  }

  public int getExpandSize() {
    return expandSize;
  }

  public void setExpandSize(int expandSize) {
    this.expandSize = expandSize;
  }

  public Boolean isMaximized() {
    return maximized;
  }

  public void setMaximized(Boolean maximized) {
    this.maximized = maximized;
  }
}
