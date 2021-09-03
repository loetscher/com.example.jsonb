
package com.example.jsonb.extendsmap;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

class MapSuperclassTest {

  @Test
  void objectExtendsHashmap() {
    Jsonb jsonb = JsonbBuilder.create();
    MapSuperclass changes = jsonb.fromJson("{" //
            + "            \"decision.grid\": {\r\n" //
            + "                \"cursorColumn\": -99\r\n" //
            + "            }" + "        }", MapSuperclass.class);
    Object singleChange = changes.get("decision.grid");
    assertThat(singleChange, instanceOf(SomeDto.class));
    assertNotNull(singleChange);

  }

  @Test
  void HashmapDirect() {
    Jsonb jsonb = JsonbBuilder.create();
    Map<String, SomeDto> changes = jsonb.fromJson("{" //
                    + "            \"decision.grid\": {\r\n" //
                    + "                \"cursorColumn\": -99\r\n" //
                    + "            }" + "        }",
            HashMap.class);
    Object singleChange = changes.get("decision.grid");
    assertThat(singleChange, instanceOf(SomeDto.class));
    assertNotNull(singleChange);

  }


}
