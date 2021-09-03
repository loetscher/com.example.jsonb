
package com.example.jsonb.extendsmap;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

class UseMapSupperclassTest {

  @Test
  void objectExtendsHashmapDeserializeTest() {
    Jsonb jsonb = JsonbBuilder.create();
    UseMapSupperclass changes = jsonb.fromJson("{ \"value\": {" //
            + "            \"decision.grid\": {" //
            + "                \"cursorColumn\": -99" //
            + "            }" + "        }}", UseMapSupperclass.class);
    MapSuperclass singleChange = changes.getValue();
    assertThat(singleChange.get("decision.grid"), instanceOf(SomeDto.class));
    assertNotNull(singleChange);
  }

  @Test
  void objectExtendsHashmapSerializeTest() {
    Jsonb jsonb = JsonbBuilder.create();
    MapSuperclass cut = new MapSuperclass();
    SomeDto dto = new SomeDto();
    dto.setValue("dtoValue1");
    dto.setValue2("dtoValue2");
    cut.put("mykey", dto);

    dto = new SomeDto();
    dto.setValue("dtoValue1");
    dto.setValue2("dtoValue2");
    cut.put("mykey2", dto);
    System.out.println(jsonb.toJson(cut));
  }

}
