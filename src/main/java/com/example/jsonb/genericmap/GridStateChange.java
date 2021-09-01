
package com.example.jsonb.genericmap;

import java.util.HashMap;
import java.util.Map;

public class GridStateChange {
  private Map<Integer, Map<String, String>> rowsWritable; // key = rowIndex

  public GridStateChange() {
    this.rowsWritable = new HashMap<>();
  }

  public Map<Integer, Map<String, String>> getRowsWritable() {
    return rowsWritable;
  }

  public void setRowsWritable(Map<Integer, Map<String, String>> rowsWritable) {
    this.rowsWritable = rowsWritable;
  }
}