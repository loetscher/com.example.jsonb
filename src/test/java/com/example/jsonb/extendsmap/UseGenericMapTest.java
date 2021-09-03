
package com.example.jsonb.extendsmap;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

class UseGenericMapTest {

  private static final String JSON_SAMPLE = "{ \"value\": {" //
          + "            \"decision.grid\": {" //
          + "                \"cursorColumn\": -99" //
          + "            }}}";

  @Test
  void objectExtendsHashmapJsonB() {
    Jsonb jsonb = JsonbBuilder.create();
    UseGenericMap changes = jsonb.fromJson(JSON_SAMPLE, UseGenericMap.class);
    Map<String, SomeDto> singleChange = changes.getValue();
    assertNotNull(singleChange);
    assertThat(singleChange.get("decision.grid"), instanceOf(SomeDto.class));
  }

  @Test
  void objectExtendsHashmapJackson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    UseGenericMap changes = objectMapper.readValue(JSON_SAMPLE, UseGenericMap.class);
    Map<String, SomeDto> singleChange = changes.getValue();
    assertNotNull(singleChange);
    assertThat(singleChange.get("decision.grid"), instanceOf(SomeDto.class));
  }

}
