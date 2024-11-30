package com.jpa.practice;

import com.jpa.practice.dto.IdNameCodeDTO;
import com.jpa.practice.util.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtilTest {
    public static void main(String[] args) {
        // Test 1: Convert Object to JSON
        IdNameCodeDTO dto = IdNameCodeDTO.builder()
                .id(1)
                .name("John Doe")
                .code("JD001")
                .build();
        String json = JsonUtil.toJson(dto);
        System.out.println("JSON from Object: " + json);

        // Test 2: Convert JSON to Object
        String jsonInput = "{\"id\":1,\"name\":\"John Doe\",\"code\":\"JD001\"}";
        IdNameCodeDTO parsedDto = JsonUtil.fromJson(jsonInput, IdNameCodeDTO.class);
        System.out.println("Object from JSON: " + parsedDto);

        // Test 3: Convert JSON to Map
        String jsonMapInput = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        Map<String, String> map = JsonUtil.fromJson(jsonMapInput, HashMap.class, String.class, String.class);
        System.out.println("Map from JSON: " + map);

        // Test 4: Convert Map to List of DTOs
        Map<String, String> linkedHashMap = new HashMap<>();
        linkedHashMap.put("code1", "name1");
        linkedHashMap.put("code2", "name2");

        List<IdNameCodeDTO> dtoList = JsonUtil.convertLinkedHashMapToList(linkedHashMap);
        System.out.println("DTO List from Map: " + dtoList);


        Map<String, String> linkedHashMap2 = new HashMap<>();
        linkedHashMap2.put("code1", "{\"id\":1,\"name\":\"Name1\",\"sortOrderNum\":1,\"isRequestable\":true}");
        List<IdNameCodeDTO> dtoList2 = JsonUtil.convertLinkedHashMapToList2(linkedHashMap2);
        System.out.println("DTO List from Map: " + dtoList2);
        linkedHashMap2.put("code2", "{\"id\":2,\"name\":\"Name2\",\"sortOrderNum\":2,\"isRequestable\":false}");
        List<IdNameCodeDTO> dtoList3 = JsonUtil.convertLinkedHashMapToList2(linkedHashMap2);
        System.out.println("DTO List from Map: " + dtoList3);



    }
}
