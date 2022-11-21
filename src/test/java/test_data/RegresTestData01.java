package test_data;

import java.util.HashMap;
import java.util.Map;

public class RegresTestData01 {

    public Map<String, String> regrestDataMap(String name, String year, String color, String pantone_value) {
        Map<String, String> regrestDataMap = new HashMap<>();
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

    public Map<Object, Object> expectedDataMapSetUp( Map<String, String> regrestDataMap,  Map<String, String> supportDataMap) {

        Map<Object, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("data", regrestDataMap);
        expectedDataMap.put("support", supportDataMap);

        return expectedDataMap;

    }
}

}
