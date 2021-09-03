
package com.example.jsonb.genericmap;

import java.util.HashMap;
import java.util.Map;

public class ClassContainsMemberHashMapWithIntegerKey {
  private Map<Integer, Boolean> rowsWritable; // key = rowIndex

  public ClassContainsMemberHashMapWithIntegerKey() {
    this.rowsWritable = new HashMap<>();
  }

  public Map<Integer, Boolean> getRowsWritable() {
    return rowsWritable;
  }

  public void setRowsWritable(Map<Integer, Boolean> rowsWritable) {
    this.rowsWritable = rowsWritable;
  }
}
