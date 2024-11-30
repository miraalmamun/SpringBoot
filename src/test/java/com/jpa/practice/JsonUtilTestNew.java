package com.jpa.practice;

import com.jpa.practice.util.JsonUtil;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
public class JsonUtilTestNew {
    public static void main(String[] args) {
        // Test 1: Valid JSON with String keys and String values
        String jsonString = "{\"key1\":\"value1\", \"key2\":\"value2\"}";
        Map<String, String> resultMap = JsonUtil.fromJson(jsonString, HashMap.class, String.class, String.class);
        System.out.println("Test 1 - Map: " + resultMap);
        Assertions.assertEquals(2, resultMap.size());
        Assertions.assertEquals("value1", resultMap.get("key1"));

        // Test 2: Valid JSON with String keys and Integer values
        String jsonStringIntValues = "{\"key1\":1, \"key2\":2}";
        Map<String, Integer> resultIntMap = JsonUtil.fromJson(jsonStringIntValues, HashMap.class, String.class, Integer.class);
        System.out.println("Test 2 - Map: " + resultIntMap);
        Assertions.assertEquals(2, resultIntMap.size());
        Assertions.assertEquals(1, resultIntMap.get("key1"));

        // Test 3: Empty JSON string
        String emptyJson = "";
        Map<String, String> emptyMap = JsonUtil.fromJson(emptyJson, HashMap.class, String.class, String.class);
        System.out.println("Test 3 - Map (empty JSON): " + emptyMap);
        Assertions.assertTrue(emptyMap.isEmpty());

        // Test 4: Null JSON string
        String nullJson = null;
        Map<String, String> nullMap = JsonUtil.fromJson(nullJson, HashMap.class, String.class, String.class);
        System.out.println("Test 4 - Map (null JSON): " + nullMap);
        Assertions.assertTrue(nullMap.isEmpty());

        // Test 5: Invalid JSON
        String invalidJson = "{key1:\"value1\", \"key2\":\"value2\""; // Missing closing brace
        Map<String, String> invalidMap = JsonUtil.fromJson(invalidJson, HashMap.class, String.class, String.class);
        System.out.println("Test 5 - Map (invalid JSON): " + invalidMap);
        Assertions.assertTrue(invalidMap.isEmpty());

        // Test 6: Unsupported Map class
        try {
            Map<String, String> unsupportedMap = JsonUtil.fromJson(jsonString, null, String.class, String.class);
            System.out.println("Test 6 - Unsupported Map: " + unsupportedMap);
        } catch (Exception e) {
            System.out.println("Test 6 - Exception: " + e.getMessage());
        }
    }
}