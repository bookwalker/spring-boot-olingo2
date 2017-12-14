package com.example.contact;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
class OdataConfig {

	static final String NAMESPACE = "com.example.contact";
	static final String SERVICE_URL = "/odata/v2/";

	@Bean
	ServletRegistrationBean odataServlet(EntityManagerFactory emf) {
		JpaOdataServiceFactory jpaOdataServiceFactory = new JpaOdataServiceFactory(emf, NAMESPACE);
		return new ServletRegistrationBean(
				new JpaODataServlet(jpaOdataServiceFactory), SERVICE_URL + "*");
	}


	class JpaODataServlet extends ODataServlet {
		private final JpaOdataServiceFactory jpaOdataServiceFactory;

		public JpaODataServlet(JpaOdataServiceFactory jpaOdataServiceFactory) {
			this.jpaOdataServiceFactory = jpaOdataServiceFactory;
		}

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			req.setAttribute(ODataServiceFactory.FACTORY_INSTANCE_LABEL, jpaOdataServiceFactory);
			super.service(req, resp);
		}
	}
}
