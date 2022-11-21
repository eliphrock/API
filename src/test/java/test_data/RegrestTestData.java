package test_data;

import java.util.HashMap;
import java.util.Map;

public class RegrestTestData {
    /*
        {
            "data": {
            "id": 3,
                    "email": "emma.wong@reqres.in",
                    "first_name": "Emma",
                    "last_name": "Wong",
                    "avatar": "https://reqres.in/img/faces/3-image.jpg"
        },
            "support": {
            "url": "https://reqres.in/#support-heading",
                    "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
        }


     */
    public Map<String, String> regrestDataMap(String email, String first_name, String last_name, String avatar) {
        Map<String, String> regrestDataMap = new HashMap<>();
        regrestDataMap.put("email", email);
        regrestDataMap.put("first_name", first_name);
        regrestDataMap.put("last_name", last_name);
        regrestDataMap.put("avatar", avatar);

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
