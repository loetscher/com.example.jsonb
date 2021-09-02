
package com.example.jsonb;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import com.example.jsonb.genericmap.GridStateChange;
import com.fasterxml.jackson.databind.ObjectMapper;

class JsonApiDtoTest {

  private static JsonApiDto DTO;

  static {
    DTO = new JsonApiDto(new Links().setSelf("self").setLast("last").setNext("next"));
  }

  @Test
  void serialiceWithJsonB() {

    Jsonb jsonb = JsonbBuilder.create();
    String dtoSerialized = jsonb.toJson(DTO, GridStateChange.class);

    assertNotNull(dtoSerialized);

  }

  @Test
  void serializeWithJackson() throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();
    String dtoSerialized = objectMapper.writeValueAsString(DTO);

    assertNotNull(dtoSerialized);

  }

}