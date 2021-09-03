
package com.example.jsonb.extendsmap;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Map;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

class UseGenericMapTest {

  @Test
  void objectExtendsHashmap() {
    Jsonb jsonb = JsonbBuilder.create();
    UseGenericMap changes = jsonb.fromJson("{ \"value\": {" //
            + "            \"decision.grid\": {" //
            + "                \"cursorColumn\": -99" //
            + "            }" + "        }}", UseGenericMap.class);
    Map<String, SomeDto> singleChange = changes.getValue();
    assertThat(singleChange.get("decision.grid"), instanceOf(SomeDto.class));
    assertNotNull(singleChange);
  }

}
