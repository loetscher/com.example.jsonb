
package com.example.jsonb.genericmap;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class ClassContainsMemberHashMapWithIntegerKeyTest {

  private static final String JSON_SAMPLE = "{" //
      + "                \"rowsWritable\": {" //
      + "                    \"9\": \"true\"" //
      + "                }" //
      + "            }";

  @Test
  void deserializeWithJsonB() {

    Jsonb jsonb = JsonbBuilder.create();
    ClassContainsMemberHashMapWithIntegerKey classContainsMemberHashMapWithIntegerKey = jsonb.fromJson(JSON_SAMPLE, ClassContainsMemberHashMapWithIntegerKey.class);

    // parsing the above json with jsonb, this assertion fails as the key is of type String instead of Integer
    assertTrue(classContainsMemberHashMapWithIntegerKey.getRowsWritable().containsKey(Integer.valueOf(9)));

  }

  @Test
  void deserializeWithJackson() throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();
    ClassContainsMemberHashMapWithIntegerKey classContainsMemberHashMapWithIntegerKey = objectMapper.readValue(JSON_SAMPLE, ClassContainsMemberHashMapWithIntegerKey.class);

    // parsing the above json with jackson, this assertion IS "true" as the key is set as an Integer (as in ClassContainsMemberHashMapWithIntegerKey defined)
    assertTrue(classContainsMemberHashMapWithIntegerKey.getRowsWritable().containsKey(Integer.valueOf(9)));

  }

}
