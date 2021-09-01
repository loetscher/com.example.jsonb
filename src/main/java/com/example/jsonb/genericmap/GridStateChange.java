
package com.example.jsonb.genericmap;

import java.io.Serializable;
import java.util.Map;

public class GridStateChange extends GridState implements Serializable {
  private static final long serialVersionUID = 1L;
  private Map<String, Map<String, String>> rowsWritable; // key = rowIndex

  public Map<String, Map<String, String>> getRowsWritable() {
    return rowsWritable;
  }

  public void setRowsWritable(Map<String, Map<String, String>> rowsWritable) {
    this.rowsWritable = rowsWritable;
  }

}
