package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

   protected static ObjectMapper mapper;

   static {//static block works before every process and this object will be created
       mapper=new ObjectMapper();
   }
   //this method will accept two parameters and convert first parameter to second parameter data type by using ObjectMapper class.
   public static <T> T convertJsonToJavaObject(String json,Class<T> cls){
            T javaResult=null;
       try {
           javaResult=mapper.readValue(json,cls);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

       return  javaResult;
   }

}
