
package com.example.jsonb.genericmap;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class GridStateChangeTest {

  private static final String JSON_SAMPLE = "{" //
      + "                \"rowsWritable\": {" //
      + "                    \"9\": \"true\"" //
      + "                }" //
      + "            }";

  @Test
  void deserializeWithJsonB() {

    Jsonb jsonb = JsonbBuilder.create();
    GridStateChange gridStateChange = jsonb.fromJson(JSON_SAMPLE, GridStateChange.class);

    // parsing the above json with jackson, this assertion fails as the key is of type String, not Integer
    assertTrue(gridStateChange.getRowsWritable().containsKey(Integer.valueOf(9)));

  }

  @Test
  void deserializeWithJackson() throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();
    GridStateChange gridStateChange = objectMapper.readValue(JSON_SAMPLE, GridStateChange.class);

    // parsing the above json with jackson, this assertion IS "true"
    assertTrue(gridStateChange.getRowsWritable().containsKey(Integer.valueOf(9)));

  }

}