package mtdp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

/**
 * web.xml 配置类
 *
 * @author wangte
 * @date created at 2018/11/8
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 在servletContext.addServlet之后，定制化属性，包括基本servlet的属性和dispatcher-servlet的扩展属性
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //registration.setLoadOnStartup(1);
        //registration.setAsyncSupported(true);
        //registration.setInitParameter("dispatchOptionsRequest", "true");
    }

    @Override
    protected String getServletName() {
        return "dispatch-servlet";
    }
}
