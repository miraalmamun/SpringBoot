package com.jpa.practice;

import com.jpa.practice.dto.IdNameCodeDTO;
import com.jpa.practice.util.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtilComprehensiveTest {
    public static void main(String[] args) {
        testToJson();
        testFromJsonToObject();
        testFromJsonToMap();
        testConvertLinkedHashMapToList();
    }

    private static void testToJson() {
        System.out.println("=== Testing toJson ===");

        // Test 1: Serialize a DTO
        IdNameCodeDTO dto = IdNameCodeDTO.builder()
                .id(1)
                .name("John Doe")
                .code("JD001")
                .build();
        String dtoJson = JsonUtil.toJson(dto);
        System.out.println("DTO to JSON: " + dtoJson);

        // Test 2: Serialize a Map
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String mapJson = JsonUtil.toJson(map);
        System.out.println("Map to JSON: " + mapJson);

        // Test 3: Serialize a null object
        String nullJson = JsonUtil.toJson(null);
        System.out.println("Null to JSON: " + nullJson);
    }

    private static void testFromJsonToObject() {
        System.out.println("\n=== Testing fromJson to Object ===");

        // Test 1: Valid JSON to DTO
        String validDtoJson = "{\"id\":1,\"name\":\"John Doe\",\"code\":\"JD001\"}";
        IdNameCodeDTO parsedDto = JsonUtil.fromJson(validDtoJson, IdNameCodeDTO.class);
        System.out.println("JSON to DTO: " + parsedDto);

        // Test 2: Invalid JSON to DTO
        String invalidDtoJson = "{id:1,name:\"John Doe\"}";
        IdNameCodeDTO invalidParsedDto = JsonUtil.fromJson(invalidDtoJson, IdNameCodeDTO.class);
        System.out.println("Invalid JSON to DTO: " + invalidParsedDto);

        // Test 3: Null JSON to DTO
        IdNameCodeDTO nullDto = JsonUtil.fromJson(null, IdNameCodeDTO.class);
        System.out.println("Null JSON to DTO: " + nullDto);
    }

    private static void testFromJsonToMap() {
        System.out.println("\n=== Testing fromJson to Map ===");

        // Test 1: Valid JSON to Map
        String validMapJson = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        Map<String, String> validMap = JsonUtil.fromJson(validMapJson, HashMap.class, String.class, String.class);
        System.out.println("JSON to Map: " + validMap);

        // Test 2: Invalid JSON to Map
        String invalidMapJson = "{\"key1\":\"value1\",\"key2\"}";
        Map<String, String> invalidMap = JsonUtil.fromJson(invalidMapJson, HashMap.class, String.class, String.class);
        System.out.println("Invalid JSON to Map: " + invalidMap);

        // Test 3: Null JSON to Map
        Map<String, String> nullMap = JsonUtil.fromJson(null, HashMap.class, String.class, String.class);
        System.out.println("Null JSON to Map: " + nullMap);
    }

    private static void testConvertLinkedHashMapToList() {
        System.out.println("\n=== Testing convertLinkedHashMapToList ===");

        // Test 1: Valid LinkedHashMap
        Map<String, String> linkedHashMap = new HashMap<>();
        linkedHashMap.put("code1", "name1");
        linkedHashMap.put("code2", "name2");
        List<IdNameCodeDTO> dtoList = JsonUtil.convertLinkedHashMapToList(linkedHashMap);
        System.out.println("LinkedHashMap to DTO List: " + dtoList);

        // Test 2: Empty LinkedHashMap
        Map<String, String> emptyMap = new HashMap<>();
        List<IdNameCodeDTO> emptyList = JsonUtil.convertLinkedHashMapToList(emptyMap);
        System.out.println("Empty LinkedHashMap to DTO List: " + emptyList);

        // Test 3: Null LinkedHashMap
        List<IdNameCodeDTO> nullList = JsonUtil.convertLinkedHashMapToList(null);
        System.out.println("Null LinkedHashMap to DTO List: " + nullList);
    }
}
