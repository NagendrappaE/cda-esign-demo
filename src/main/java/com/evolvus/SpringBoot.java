package com.evolvus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.evolvus")
public class SpringBoot

		extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBoot.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}
	/*
	 * @Bean public EmbeddedServletContainerFactory servletContainer() {
	 * TomcatEmbeddedServletContainerFactory tomcat = new
	 * TomcatEmbeddedServletContainerFactory() {
	 * 
	 * @Override protected void postProcessContext(Context context) {
	 * SecurityConstraint securityConstraint = new SecurityConstraint();
	 * securityConstraint.setUserConstraint("CONFIDENTIAL"); SecurityCollection
	 * collection = new SecurityCollection(); collection.addPattern("/*");
	 * securityConstraint.addCollection(collection);
	 * context.addConstraint(securityConstraint); } };
	 * 
	 * tomcat.addAdditionalTomcatConnectors(initiateHttpConnector()); return
	 * tomcat; }
	 * 
	 * private Connector initiateHttpConnector() { Connector connector = new
	 * Connector("org.apache.coyote.http11.Http11NioProtocol");
	 * connector.setScheme("http"); connector.setPort(8081);
	 * connector.setSecure(false); connector.setRedirectPort(9443);
	 * 
	 * return connector; }
	 */
}
