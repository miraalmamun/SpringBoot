package com.jpa.practice;

import com.jpa.practice.util.JsonUtil;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtilComplexTest {
    public static void main(String[] args) {
        // Complex JSON string
        String complexJson = """
                {
                  "user": {
                    "id": 101,
                    "name": "Alice",
                    "details": {
                      "age": 30,
                      "address": {
                        "street": "123 Elm Street",
                        "city": "Wonderland",
                        "zipcode": "12345"
                      },
                      "preferences": {
                        "colors": ["red", "green", "blue"],
                        "newsletterSubscribed": true
                      }
                    },
                    "contacts": [
                      {
                        "type": "email",
                        "value": "alice@example.com"
                      },
                      {
                        "type": "phone",
                        "value": "123-456-7890"
                      }
                    ]
                  }
                }
                """;

        // Test 1: Convert JSON to Map<String, Object>
        Map<String, Object> result = JsonUtil.fromJson(complexJson, HashMap.class, String.class, Object.class);
        System.out.println("Complex Map: " + result);

        // Assertions for verification
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.containsKey("user"));

        Map<String, Object> user = (Map<String, Object>) result.get("user");
        Assertions.assertEquals(101, user.get("id"));
        Assertions.assertEquals("Alice", user.get("name"));

        // Test nested structures
        Map<String, Object> details = (Map<String, Object>) user.get("details");
        Assertions.assertEquals(30, details.get("age"));

        Map<String, String> address = (Map<String, String>) details.get("address");
        Assertions.assertEquals("123 Elm Street", address.get("street"));

        Map<String, Object> preferences = (Map<String, Object>) details.get("preferences");
        List<String> colors = (List<String>) preferences.get("colors");
        Assertions.assertEquals(List.of("red", "green", "blue"), colors);

        // Test array of objects
        List<Map<String, String>> contacts = (List<Map<String, String>>) user.get("contacts");
        Assertions.assertEquals(2, contacts.size());
        Assertions.assertEquals("email", contacts.get(0).get("type"));
        Assertions.assertEquals("alice@example.com", contacts.get(0).get("value"));

        System.out.println("Test passed for complex JSON!");
    }}