
package com.example.jsonb.innerclass;

import static org.junit.Assert.assertNotNull;

import com.example.jsonb.innerclass.JsonApiDto;
import com.example.jsonb.innerclass.LinkExt;
import com.example.jsonb.innerclass.Links;
import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class JsonApiDtoTest {

  private static JsonApiDto DTO;

  static {
    DTO = new JsonApiDto(new Links().setSelf("self").setLast("last").setNext("next"));
  }

  @Test
  void serializeLinkExtJsonB() {

    LinkExt link = new LinkExt();
    link.setSelf("self");
    link.setLast("last");
    link.setNext("next");

    Jsonb jsonb = JsonbBuilder.create();
    String linkString = jsonb.toJson(link);

    assertNotNull(linkString);

  }

  @Test
  void serializeLinkJsonB() {

    Links link = new Links();
    link.setSelf("self");
    link.setLast("last");
    link.setNext("next");

    Jsonb jsonb = JsonbBuilder.create();
    String linkString = jsonb.toJson(link);

    assertNotNull(linkString);

  }

  @Test
  void serializeWithJsonB() {

    Jsonb jsonb = JsonbBuilder.create();
    String dtoSerialized = jsonb.toJson(DTO);

    assertNotNull(dtoSerialized);

  }

  @Test
  void serializeLinkJackson() throws JsonProcessingException {

    Links link = new Links();
    link.setSelf("self");
    link.setLast("last");
    link.setNext("next");

    ObjectMapper objectMapper = new ObjectMapper();
    String linkString = objectMapper.writeValueAsString(link);

    assertNotNull(linkString);

  }

  @Test
  void serializeWithJackson() throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();
    String dtoSerialized = objectMapper.writeValueAsString(DTO);

    assertNotNull(dtoSerialized);

  }

}
