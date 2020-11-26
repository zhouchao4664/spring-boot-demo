package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.MapType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class JacksonUtil {
    private static JacksonUtil _instance = new JacksonUtil();
    public static ObjectMapper objectMapper = null;

    static {
        log.info("JacksonUtil init");
        try {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        } catch (Exception e) {
            log.error("JacksonUtil init error,cause:", e);
        }
    }

    synchronized public static JacksonUtil getInstance() {
        return _instance;
    }

    /**
     * 对象转换为JSON串. <br/>
     * toJson:(obj). <br/>
     *
     * @param obj
     * @return
     * @author WangLZ
     * @since JDK 1.8
     */
    public static String toJson(Object obj) {
        String rs = null;
        try {
            rs = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("obj to json error {}", e);
            return null;
        }
        return rs;
    }

    /**
     * json串转换为JSON对象. <br/>
     * toJson:(json串). <br/>
     *
     * @param json
     * @return
     * @author WangLZ
     * @since JDK 1.8
     */
    public static JsonNode toJson(String json) {
        JsonNode node = null;
        try {
            node = objectMapper.readTree(json);
        } catch (Exception e) {
            log.error("{} to json exception {}", json, e.getMessage());
            return null;
        }
        return node;
    }

    /**
     * 自定義 写入response
     *
     * @param response
     * @param obj
     */
    public static void writeResponse(HttpServletResponse response, Object obj) {
        try {
            response.setContentType("application/json,charset=UTF-8");
            objectMapper.writeValue(response.getOutputStream(), obj);
        } catch (IOException e) {
            log.error("Write response error {} {}", obj, e);
            e.printStackTrace();
        }
    }

    /**
     * 根据json串转换java对象. <br/>
     * toObj:(json,Obj). <br/>
     *
     * @param jsonString
     * @param prototype
     * @return
     * @author lm
     * @since JDK 1.8
     */
    public static <T> T toObj(String jsonString, Class<T> prototype) throws Exception {
        try {
            return (T) objectMapper.readValue(jsonString, prototype);
        } catch (IOException e) {
            log.error("obj to json error {}", e);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * json数组转换为java对象列表. <br/>
     * toList:(jsonArray,对象类型). <br/>
     *
     * @param jsonArray
     * @param javaType
     * @return
     * @author WangLZ
     * @since JDK 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T> T toList(String jsonArray, JavaType javaType) throws Exception {
        try {
            return (T) objectMapper.readValue(jsonArray, javaType);
        } catch (IOException e) {
            log.error("json {} to List error {}", jsonArray, e);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * json对象转换为Map. <br/>
     * toMap:(jsonMap,Map的Key泛型，Map的Value泛型). <br/>
     *
     * @param jsonMap
     * @param keyClass
     * @param valueClass
     * @param <T>
     * @return
     * @throws Exception
     * @author zhouchao
     * @since JDK 1.8
     */
    public static <T> T toMap(String jsonMap, Class<?> keyClass, Class<?> valueClass) throws Exception {
        MapType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, keyClass, valueClass);
        try {
            return (T) objectMapper.readValue(jsonMap, mapType);
        } catch (IOException e) {
            log.error("json {} to Map error {}", jsonMap, e);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * json数组转换为java对象列表. <br/>
     *
     * @param jsonArray
     * @param beanType
     * @return
     * @author WangLZ
     * @since JDK 1.8
     */
    public static <T> List<T> toList(String jsonArray, Class<T> beanType) throws Exception {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = objectMapper.readValue(jsonArray, javaType);
            return list;
        } catch (Exception e) {
            log.info("json {} to list Exception, cause : {}", jsonArray, e);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 生成Jackson对象 <br/>
     *
     * @return
     * @author WangLZ
     * @since JDK 1.8
     */
    public static ObjectNode createNode() {
        return objectMapper.createObjectNode();
    }

    /**
     * getCollectionType:获取泛型的Collection Type <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @param collectionClass
     * @param elementClasses
     * @return
     * @author lm
     * @since JDK 1.8
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * map转化为指定对象 toObj:(beanType). <br/>
     *
     * @param map
     * @param beanType
     * @return
     * @author MengBing
     * @since JDK 1.8
     */
    public static <T> T toObj(Map<String, Object> map, Class<T> beanType) throws Exception {
        try {
            return objectMapper.convertValue(map, beanType);
        } catch (IllegalArgumentException e) {
            log.error("map to obj error {}", e);
            throw new Exception(e.getMessage());
        }
    }

}
