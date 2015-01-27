package com.lo.apps.ws.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.lo.apps.ws.client.service.impl.InvoiceClientServiceImpl;

@EnableWs
@Configuration
public class InvoiceClientConfiguration {

	@Bean
	public WebServiceTemplate webServiceTemplate() {
		WebServiceTemplate wsTemplate = new WebServiceTemplate();
		wsTemplate.setDefaultUri("http://localhost:8080/services");
		wsTemplate.setMarshaller(marshaller());
		wsTemplate.setUnmarshaller(unmarshaller());

		return wsTemplate;
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.lo.apps.ws.client.entity.invoice");
		marshaller.setSchema(new ClassPathResource("invoice.xsd"));

		return marshaller;
	}

	@Bean
	public Jaxb2Marshaller unmarshaller() {
		Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
		unmarshaller.setContextPath("com.lo.apps.ws.client.entity.invoice");
		unmarshaller.setSchema(new ClassPathResource("invoice.xsd"));

		return unmarshaller;
	}

	@Bean
	public InvoiceClientServiceImpl client() {
		InvoiceClientServiceImpl client = new InvoiceClientServiceImpl();
		client.setWebServiceTemplate(webServiceTemplate());

		return client;
	}

	@Bean
	public XsdSchema invoiceSchema() {
		return new SimpleXsdSchema(new ClassPathResource("invoice.xsd"));
	}

	@Bean
	public MarshallingHttpMessageConverter marshallingConverter() {
		return new MarshallingHttpMessageConverter(marshaller(), unmarshaller());
	}

}
