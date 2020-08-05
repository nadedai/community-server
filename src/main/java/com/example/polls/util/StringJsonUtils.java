package com.example.polls.util;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author hhtt
 * @date 2020/8/4 13:05
 * description:
 */
public class StringJsonUtils {
    public static Map<String, Object> jsonStringToMap(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map = mapper.readValue(jsonString,
                    new TypeReference<HashMap<String, Object>>() {
                    });
            Set<String> set = map.keySet();
            for (String key : set) {
                String values = map.get(key).toString();
                values = values.trim();
                map.put(key, values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}