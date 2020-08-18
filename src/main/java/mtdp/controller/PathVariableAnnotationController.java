package mtdp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试PathVariable注解
 *
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date Created At 2019/12/3
 */
@RestController
@RequestMapping(value = "/api/path/value")
public class PathVariableAnnotationController {

    @GetMapping(value = "/{id}")
    public String testAnnotationPathVariable(@PathVariable(name = "id") String id) {
        return id;
    }
}
