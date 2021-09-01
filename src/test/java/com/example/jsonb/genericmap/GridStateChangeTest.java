
package com.example.jsonb.genericmap;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GridStateChangeTest {

  private static final String JSON_SAMPLE = "{" //
      + "                \"rowsWritable\": {" //
      + "                    \"9\": {" //
      + "                        \"fastchange.FastchangeGroup.Fastchange.grid.Consumption\": \"4\"" //
      + "                    }" //
      + "                }" //
      + "            }";

  @Test
  void deserializeJsonBGridStateChangeIntegerKeyTest() {
    // Create Jsonb and serialize
    Jsonb jsonb = JsonbBuilder.create();
    GridStateChangeIntegerKey gridStateChange = jsonb.fromJson(JSON_SAMPLE, GridStateChangeIntegerKey.class);

    // parsing the above json with jackson, this assertion fails as the key is of type String, not Integer
    assertTrue(gridStateChange.getRowsWritable().containsKey(Integer.valueOf(9)));

  }

  @Test
  void deserializeJacksonGridStateChangeIntegerKeyJacksonTest() throws IOException {
    // Create Jsonb and serialize
    ObjectMapper objectMapper = new ObjectMapper();
    GridStateChangeIntegerKey gridStateChange = objectMapper.readValue(JSON_SAMPLE, GridStateChangeIntegerKey.class);

    // parsing the above json with jackson, this assertion IS "true"
    assertTrue(gridStateChange.getRowsWritable().containsKey(Integer.valueOf(9)));

  }

}