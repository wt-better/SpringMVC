package mtdp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangte
 * @date created at 2018/4/8
 */
public class JacksonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        //在遇到类中没有的属性时，是否反序列化失败反序列化是根据类中属性的setter和getter来反序列化，
        // 没有属性则也没有setter和getter.如果不指明为false，那么就会反序列化失败
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJSON(Object object) {
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Object-JSON 转化失败, params : object = [{}]", object);
            LOGGER.error("Object-JSON 转化失败, errors : ex = [{}]", e);
        }
        return json;
    }

    /**
     * 将字符串反序列化成对象
     *
     * @param json        要完成反序列化的字符串
     * @param targetClass 要转化的目标类
     * @param <T>         泛型参数
     * @return java 对象
     */
    public static <T> T getObjectByStr(String json, Class<T> targetClass){
        T t = null;
        try {
            t = OBJECT_MAPPER.readValue(json, targetClass);
        } catch (Exception e) {
            LOGGER.error("JSON-Object 转化失败, params : JSON = [{}], targetClass = [{}]",json, targetClass);
            LOGGER.error("JSON-Object 转化失败, errors : ex = [{}]", e);
        }
        return t;
    }


    /**
     * 将对象序列化成字符串
     *
     * @param object 即将转化的对象
     * @return 转化之后的字符串，若转化的对象为null，默认返回""
     */
    public static String toJSONWithEmptyDefault(Object object) {
        String json = "";
        try {
            json = OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Object-JSON 转化失败, params : object = [{}]", object);
            LOGGER.error("Object-JSON 转化失败, errors : ex = [{}]", e);
        }
        return json;
    }

}
