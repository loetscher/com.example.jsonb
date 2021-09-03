
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

class UseMapAsSuperclassTest {

  private static final String JSON_SAMPLE = "{ \"value\": {" //
          + "            \"decision.grid\": {" //
          + "                \"cursorColumn\": -99" //
          + "            }}}";

  @Test
  void objectExtendsHashmapDeserializeTestJsonB() {
    Jsonb jsonb = JsonbBuilder.create();
    UseMapAsSuperclass changes = jsonb.fromJson(JSON_SAMPLE, UseMapAsSuperclass.class);
    MapAsSuperclass singleChange = changes.getValue();
    assertThat(singleChange.get("decision.grid"), instanceOf(SomeDto.class));
    assertNotNull(singleChange);
  }

  @Test
  void objectExtendsHashmapDeserializeTestJackson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    UseGenericMap changes = objectMapper.readValue(JSON_SAMPLE, UseGenericMap.class);
    Map<String, SomeDto> singleChange = changes.getValue();
    assertNotNull(singleChange);
    assertThat(singleChange.get("decision.grid"), instanceOf(SomeDto.class));
  }

  @Test
  void objectExtendsHashmapSerializeTest() {
    Jsonb jsonb = JsonbBuilder.create();
    MapAsSuperclass cut = new MapAsSuperclass();
    SomeDto dto = new SomeDto();
    dto.setCursorColumn(123);
    cut.put("mykey", dto);

    dto = new SomeDto();
    dto.setCursorColumn(789);
    cut.put("mykey2", dto);
    System.out.println(jsonb.toJson(cut));
  }

}
