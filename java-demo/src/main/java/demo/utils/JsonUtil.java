package demo.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    public static final ObjectMapper OM = new ObjectMapper();
    static{
    	// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性  
        OM.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        OM.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }
    
    public static JavaType assignList(Class<? extends Collection> collection, Class<? extends Object> object) {
        return JsonUtil.OM.getTypeFactory().constructParametricType(collection, object);
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }


    public static <T> ArrayList<T> readValuesAsArrayList(String key, Class<T> object) {
        ArrayList<T> list = null;
        try {
            list = OM.readValue(key, assignList(ArrayList.class, object));
        } catch (JsonParseException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return list;
    }


    public static String toJson(Object obj){
    	if(obj == null){
    		return "";
    	}
        try {
            return OM.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static String prettyJson(String json) {
        if (StringUtils.isBlank(json)) {
            return json;
        }

        try {
            JSONObject jsonObject = JSONObject.parseObject(json, Feature.OrderedField);
            return JSONObject.toJSONString(jsonObject, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
            return json;
        }
    }

    public static boolean isJson(String str) {
        try {
            JSONObject.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String toJson(Object obj, String callback){
        if(obj instanceof String){
            return (String)obj;
        }
        String rs = null;
        try {
            JsonUtil.OM.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            rs = JsonUtil.OM.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        if(rs == null){
            rs = "{\"rc\":-1}";//解析JSON异常/IO异常
        }
        if(StringUtils.isNotEmpty(callback)){
            rs = String.format("%s(%s)", callback, rs);
        }

        return rs;

    }

    /**
     * 
    * @Description: 重载个性化时间
    * @author yuzj7@lenovo.com  
    * @date 2015年8月9日 下午4:19:18
    * @param sdf
    * @param json
    * @param clazz
    * @return
     */
    public static <T> T fromJson(SimpleDateFormat sdf,String json, Class<T> clazz){
        try {
        	OM.setDateFormat(sdf);
            T t =  OM.readValue(json, clazz);
            OM.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return t;
        } catch (JsonParseException e) {
            logger.error("fromJson error json={}",json);
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error("fromJson error json={}",json);
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error("fromJson error json={}",json);
            logger.error(e.getMessage(),e);
        }
        return null;
    }
    
    public static <T> T fromJson(String json, Class<T> clazz){
        try {
            return OM.readValue(json, clazz);
        } catch (JsonParseException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

     public static String obj2json(Object obj)  {
        try {
        	if(null == obj){
        		return "";
        	}
        	if(obj instanceof HttpServletResponse){
        	    return "";
            }
			return OM.writeValueAsString(obj);
		} catch (Exception e) {
            logger.error("",e);
			return "";
		}
    }

    public static <T> List<T> castList(Object obj, Class<T> clazz)
    {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
