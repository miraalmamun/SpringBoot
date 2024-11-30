package com.jpa.practice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.jpa.practice.dto.IdNameCodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JsonUtil {

    JsonUtil() {
        throw new IllegalStateException("Utility class");
    }


    public static String toJson(Object object) {

        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Error converting object to JSON", e);
            return null;
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.hasText(json)) {
            return null;
        }
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("Error converting object to JSON", e);
            return null;
        }
    }

    //JSON FOR GENERIC MAPS AND TYPE SAFETY
    public static <K, V> Map<K, V> fromJson(String json, Class<? extends Map> mapClass, Class<K> keyclass, Class<V> valueClass) {
        if (StringUtils.hasText(json)) {
            return getEmtpMap(mapClass);
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeFactory typeFactory = mapper.getTypeFactory();
            return mapper.readValue(json, typeFactory.constructMapType(mapClass, keyclass, valueClass));
        } catch (JsonProcessingException e) {
            log.error("Error converting JSON to object", e);
            return getEmtpMap(mapClass);
        }
    }

    private static <K, V> Map<K, V> getEmtpMap(Class<? extends Map> mapClass) {
        try {
            return mapClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Error cannot initializer Map of type {} defaulting to hasMap", mapClass, e);

            return new HashMap<>();
        }
    }


    public static List<IdNameCodeDTO> convertLinkedHashMapToList(Map<String, String> linkedHashMap) {
        List<IdNameCodeDTO> idNameCodeDTOList = new ArrayList<>();

        if (linkedHashMap != null) {
            idNameCodeDTOList = (List<IdNameCodeDTO>) linkedHashMap.entrySet().stream().map(entry -> IdNameCodeDTO.builder().code(entry.getKey()).build()).toList();
        }

        return idNameCodeDTOList;
    }

}


















