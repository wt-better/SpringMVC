package mtdp.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试InitBinder注解
 *
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date Created At 2019/12/4
 */
@RestController
@RequestMapping(value = "/api/init/binder")
public class InitBinderController {

    /**
     * 在WebDataBinder中注册PropertyEditor
     *
     * @param binder org.springframework.web.bind.WebDataBinder
     */
    @InitBinder
    public void init(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }

    @GetMapping(value = "/date")
    public String testInitBinder(Date date) {
        return date.toString();
    }
}
