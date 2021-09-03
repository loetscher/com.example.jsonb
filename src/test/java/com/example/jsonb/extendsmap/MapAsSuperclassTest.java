
package com.example.jsonb.extendsmap;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

class MapAsSuperclassTest {

  @Test
  void objectExtendsHashmap() {
    Jsonb jsonb = JsonbBuilder.create();
    MapAsSuperclass changes = jsonb.fromJson("{" //
            + "            \"decision.grid\": {\r\n" //
            + "                \"cursorColumn\": -99\r\n" //
            + "            }" + "        }", MapAsSuperclass.class);
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
