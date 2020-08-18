package mtdp.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date Created At 2020/2/1
 */
@Controller
@RequestMapping(value = "/api/environment")
public class EnvironmentController implements EnvironmentCapable, EnvironmentAware {

    /**
     * 获取PropertySources
     * org.springframework.core.env.ConfigurableEnvironment#getPropertySources()
     */
    private Environment environment;

    @RequestMapping(value = "")
    public void testEnvironment() {

    }


    @Override
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * 这里的environment是org.springframework.web.context.support.StandardServletEnvironment
     * environment中的propertySources包含5个属性
     * 1）ServletConfigPropertySource
     * 存放的是容器（Tomcat）对应的ServletConfig类型
     * 2）ServletContextPropertySource
     * 保存ServletContext
     * 3）JndiPropertySource
     * 4）MapPropertySource
     * 存放虚拟机属性，如java的版本，操作系统的名称、版本号等
     * 5）SystemEnvironmentPropertySource
     * 存放环境变量
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
