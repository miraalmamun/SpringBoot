package com.jpa.practice;

import com.jpa.practice.dto.IdNameCodeDTO;
import com.jpa.practice.util.JsonUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Test 1: Object to JSON
        IdNameCodeDTO dto = IdNameCodeDTO.builder()
                .id(1)
                .name("Test Name")
                .code("T001")
                .sortOrderNum("1")
                .isResettable(true)
                .build();
        
        String json = JsonUtil.toJson(dto);
        System.out.println("Serialized JSON: " + json);

        // Test 2: JSON to Object
        String jsonString = """
                {
                    "id": 2,
                    "name": "Another Name",
                    "code": "T002",
                    "sortOrderNum": "2",
                    "isResettable": false
                }
                """;

        IdNameCodeDTO deserializedDto = JsonUtil.fromJson(jsonString, IdNameCodeDTO.class);
        System.out.println("Deserialized DTO: " + deserializedDto);

        // Test 3: JSON to Map
        String jsonMapString = """
                {
                    "key1": "value1",
                    "key2": "value2"
                }
                """;

        Map<String, String> map = JsonUtil.fromJson(jsonMapString, Map.class, String.class, String.class);
        System.out.println("Deserialized Map: " + map);

        // Test 4: Convert Map to DTO List
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Code1", """
                {
                    "id": 101,
                    "name": "Name1",
                    "sortOrderNum": "5"
                }
                """);
        linkedHashMap.put("Code2", """
                {
                    "id": 102,
                    "name": "Name2",
                    "sortOrderNum": "10"
                }
                """);

        List<IdNameCodeDTO> dtoList = JsonUtil.convertLinkedHashMapToList2(linkedHashMap);
        System.out.println("DTO List: " + dtoList);
    }
}
