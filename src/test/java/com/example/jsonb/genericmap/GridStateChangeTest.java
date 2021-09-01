
package com.example.jsonb.genericmap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GridStateChangeTest {

  /**
   * Test if keys for rowsWriteble entries are Strings. With jackson the key-type for getRowsWritable was Integer and jackson parsed it that
   * way, but jsonb parsed it as String.
   */
  @Test
  void deserializeJsonBGridStateChangeTest() {
    // Create Jsonb and serialize
    Jsonb jsonb = JsonbBuilder.create();
    GridStateChange gridStateChange = jsonb.fromJson("{" //
        + "                \"selection\": [" //
        + "                    9" //
        + "                ]," //
        + "                \"cursorColumn\": 2," //
        + "                \"vScroll\": 0," //
        + "                \"expandSize\": 60," //
        + "                \"rowsWritable\": {" //
        + "                    \"9\": {" //
        + "                        \"fastchange.FastchangeGroup.Fastchange.grid.Consumption\": \"4\"" //
        + "                    }" //
        + "                }" //
        + "            }", GridStateChange.class);
    assertNotNull(gridStateChange.getRowsWritable());
    assertFalse(gridStateChange.getRowsWritable().isEmpty());
    // parsing the above json with jackson, this assertion would be "true"
    assertFalse(gridStateChange.getRowsWritable().containsKey(9));
    assertTrue(gridStateChange.getRowsWritable().containsKey("9"));

  }

  @Test
  void deserializeJsonBGridStateChangeIntegerKeyTest() {
    // Create Jsonb and serialize
    Jsonb jsonb = JsonbBuilder.create();
    GridStateChangeIntegerKey gridStateChange = jsonb.fromJson("{" //
        + "                \"selection\": [" //
        + "                    9" //
        + "                ]," //
        + "                \"cursorColumn\": 2," //
        + "                \"vScroll\": 0," //
        + "                \"expandSize\": 60," //
        + "                \"rowsWritable\": {" //
        + "                    \"9\": {" //
        + "                        \"fastchange.FastchangeGroup.Fastchange.grid.Consumption\": \"4\"" //
        + "                    }" //
        + "                }" //
        + "            }", GridStateChangeIntegerKey.class);
    assertNotNull(gridStateChange.getRowsWritable());
    assertFalse(gridStateChange.getRowsWritable().isEmpty());
    // parsing the above json with jackson, this assertion WOULD BE "true"
    assertFalse(gridStateChange.getRowsWritable().containsKey(9));
    assertTrue(gridStateChange.getRowsWritable().containsKey("9"));

  }

  @Test
  void deserializeJacksonGridStateChangeIntegerKeyJacksonTest() throws IOException {
    // Create Jsonb and serialize
    ObjectMapper objectMapper = new ObjectMapper();
    GridStateChangeIntegerKey gridStateChange = objectMapper.readValue("{" //
        + "                \"selection\": [" //
        + "                    9" //
        + "                ]," //
        + "                \"cursorColumn\": 2," //
        + "                \"vScroll\": 0," //
        + "                \"expandSize\": 60," //
        + "                \"rowsWritable\": {" //
        + "                    \"9\": {" //
        + "                        \"fastchange.FastchangeGroup.Fastchange.grid.Consumption\": \"4\"" //
        + "                    }" //
        + "                }" //
        + "            }", GridStateChangeIntegerKey.class);
    assertNotNull(gridStateChange.getRowsWritable());
    assertFalse(gridStateChange.getRowsWritable().isEmpty());
    // parsing the above json with jackson, this assertion IS be "true"
    assertTrue(gridStateChange.getRowsWritable().containsKey(9));
    assertFalse(gridStateChange.getRowsWritable().containsKey("9"));

  }

  @Test
  void extractGenericTypesFromMapTest() throws NoSuchFieldException, SecurityException {
    GridStateChangeIntegerKey stateChange = new GridStateChangeIntegerKey();

    Field rowsWritable = stateChange.getClass().getDeclaredField("rowsWritable");
    rowsWritable.setAccessible(true);

    ParameterizedType type = (ParameterizedType)rowsWritable.getGenericType();

    Type key = type.getActualTypeArguments()[0];
    assertSame(key, Integer.class);
    System.out.println("Key: " + key);

    Type value = type.getActualTypeArguments()[1];
    System.out.println("Value: " + value);
  }
}