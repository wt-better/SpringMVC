package mtdp.context.dateformat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * TODO 注释
 *
 * @author wangte
 * @date created at 2018/11/3
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @PostMapping(value = "")
    public User testDateFormat(User user) {
        System.out.println(user);
        return user;
    }

    @GetMapping(value = "")
    public void testParamBind(Request request) {
        System.out.println(request);
    }

    @GetMapping(value = "/t4")
    public void testParamBind3(Map<String, Object> map) {
        map.forEach((k, v) -> System.out.println(k + "-> " + v));
    }

    @GetMapping(value = "/t3")
    public void testParamBind4(@RequestParam Map<String, Object> map) {
        map.forEach((k, v) -> System.out.println(k + "-> " + v));
    }

    @GetMapping(value = "/t1")
    public void testParamBind1(List<Long> list) {
        System.out.println(list);
    }

    @GetMapping(value = "/t2")
    public void testParamBind2(@RequestParam(value = "list") List<Long> list) {
        System.out.println(list);
    }
}
