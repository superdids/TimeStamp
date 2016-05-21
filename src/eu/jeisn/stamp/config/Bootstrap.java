package eu.jeisn.stamp.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class Bootstrap extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		  BeanConfig beanConfig = new BeanConfig();
	        beanConfig.setVersion("1.0.0");
	        beanConfig.setSchemes(new String[]{"http"});
	        beanConfig.setHost("localhost:8080");
	        beanConfig.setBasePath("/api");
	        beanConfig.setResourcePackage("io.swagger.resources");
	        beanConfig.setScan(true);
	}
}
