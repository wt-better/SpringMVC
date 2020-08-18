package mtdp.controller;

import mtdp.utils.JacksonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 测试RequestParam注解 什么时候生效，生么时候不生效
 *
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date Created At 2019/12/3
 * @see org.springframework.web.method.annotation.RequestParamMethodArgumentResolver
 */
@SuppressWarnings("SpellCheckingInspection")
@RestController
@RequestMapping(value = "/api/request/param")
public class RequestParamAnnotationController {

    /**
     * 这样其实最终走到了org.springframework.web.method.annotation.MapMethodProcessor
     * /map?a=aa&b=bb
     * 输出结果{}
     */
    @GetMapping(value = "/map")
    public String testAnnotationMapRequestParam(Map<String, Object> requestMap) {
        return JacksonUtil.toJSON(requestMap);
    }

    /**
     * /map2?a=aa&b=bb
     * 这里走的其实是
     *
     * @see org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver
     * 输出结果{"a":"aa","b":"bb"}
     */
    @GetMapping(value = "/map1")
    public String testAnnotationMapRequestParam1(@RequestParam Map<String, Object> requestMap) {
        return JacksonUtil.toJSON(requestMap);
    }

    /**
     * 针对于标准了@RequestParam的map
     * 如果没有name属性，其实RequestParamMethodArgumentResolver是不会生效的
     *
     * @see String paramName = parameter.getParameterAnnotation(RequestParam.class).name();
     */
    @GetMapping(value = "/map2")
    public String testAnnotationMapRequestParam2(@RequestParam(name = "requestMap") Map<String, Object> requestMap) {
        return JacksonUtil.toJSON(requestMap);
    }


    /**
     * http://localhost:8080/api/request/param/map4?a=a
     * 这么请求返回的结果将是
     * {"a":"a"}_a
     */
    @GetMapping(value = "/map3")
    public String testAnnotationMapRequestParam3(@RequestParam Map<String, Object> requestMap, String a) {
        return JacksonUtil.toJSON(requestMap) + "_" + a;
    }

    @GetMapping(value = "/class")
    public String testClass(Class clazz) {
        return JacksonUtil.toJSON(clazz);
    }

    /**
     * org.springframework.web.method.annotation.RequestParamMethodArgumentResolver#supportsParameter(org.springframework.core.MethodParameter)
     * 142行：BeanUtils.isSimpleProperty(parameter.getNestedParameterType())
     * 针对于于简单类型的属性，即使不使用@RequestParam注解，其实RequestParamMethodArgumentResolver也是会生效的
     * 什么类型算是简单类型呢？
     * 参见：org.springframework.beans.BeanUtils#isSimpleProperty(Class)
     * 不过建议还是添加上该注解，因为其他MethodArgumentResolver行为可能会覆盖该行为
     */
    @GetMapping(value = "/simple")
    public String testSimpleProperty(Long longProperty) {
        return String.valueOf(longProperty);
    }

    /**
     * name和defaultValue可以使用spel表达式
     */
    @GetMapping(value = "/spel")
    public String testParamWithSPEL(@RequestParam(defaultValue = "#{systemProperties['java.vm.version']}") String stringProperty) {
        return stringProperty;
    }

    /**
     * 针对于 MultipartFile
     * MultipartResolutionDelegate.isMultipartArgument(parameter)会返回true，RequestParamMethodArgumentResolver也会生效
     */
    @PostMapping(value = "/multipartFile")
    public String testMultipartFile(MultipartFile multipartFile) {
        return multipartFile.getName();
    }
}
