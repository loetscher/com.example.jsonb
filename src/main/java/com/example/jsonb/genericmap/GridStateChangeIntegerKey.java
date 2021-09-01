
package com.example.jsonb.genericmap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GridStateChangeIntegerKey extends GridState implements Serializable {
  private static final long serialVersionUID = 1L;
  private Map<Integer, Map<String, String>> rowsWritable; // key = rowIndex

  public GridStateChangeIntegerKey() {
    this.rowsWritable = new HashMap<>();
  }

  public Map<Integer, Map<String, String>> getRowsWritable() {
    return rowsWritable;
  }

  public void setRowsWritable(Map<Integer, Map<String, String>> rowsWritable) {
    this.rowsWritable = rowsWritable;
  }
}