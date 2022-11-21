package test_data;

import java.util.HashMap;
import java.util.Map;

public class RegresTestData01 {

    public Map<String, Object> regrestDataMap(String name, Object year, String color, String pantone_value) {
        Map<String, Object> regrestDataMap = new HashMap<>();
        regrestDataMap.put("name", name);
        regrestDataMap.put("year", year);
        regrestDataMap.put("color", color);
        regrestDataMap.put("pantone_value", pantone_value);

        return regrestDataMap;

    }

    public Map<String, String> supportDataMap(String url, String text) {

        Map<String, String> supportDataMap = new HashMap<>();
        supportDataMap.put("url", url);
        supportDataMap.put("text", text);

        return supportDataMap;
    }

    public Map<Object, Object> expectedDataMapSetUp(Map<String, Object> regrestDataMap, Map<String, String> supportDataMap) {

        Map<Object, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("data", regrestDataMap);
        expectedDataMap.put("support", supportDataMap);

        return expectedDataMap;

    }
}

