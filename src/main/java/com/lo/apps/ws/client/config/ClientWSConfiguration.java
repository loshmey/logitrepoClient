package com.lo.apps.ws.client.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.callback.KeyStoreCallbackHandler;
import org.springframework.ws.soap.security.wss4j.support.CryptoFactoryBean;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.lo.apps.ws.client.service.impl.InvoiceClientServiceImpl;

@EnableWs
@Configuration
public class ClientWSConfiguration extends WsConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ClientWSConfiguration.class);

	@Bean
	public WebServiceTemplate webServiceTemplate() {
		logger.debug("In webServiceTemplate()...");

		WebServiceTemplate wsTemplate = new WebServiceTemplate();
		ClientInterceptor[] interceptors = { wsClientSecurityInterceptor() };

		wsTemplate.setDefaultUri("http://localhost:8080/services");
		wsTemplate.setMarshaller(marshaller());
		wsTemplate.setUnmarshaller(unmarshaller());
		wsTemplate.setInterceptors(interceptors);

		return wsTemplate;
	}

	@Bean(name = "invoice")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

		wsdl11Definition.setPortTypeName("Invoice");
		wsdl11Definition.setLocationUri("/services");
		wsdl11Definition.setTargetNamespace("http://localhost:8080/invoice/schema");
		wsdl11Definition.setSchema(invoiceSchema());

		return wsdl11Definition;
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		logger.debug("In marshaller()...");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.lo.apps.ws.client.entity.invoice");
		marshaller.setSchema(new ClassPathResource("invoice.xsd"));

		return marshaller;
	}

	@Bean
	public Jaxb2Marshaller unmarshaller() {
		logger.debug("In unmarshaller()...");
		Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();

		unmarshaller.setContextPath("com.lo.apps.ws.client.entity.invoice");
		unmarshaller.setSchema(new ClassPathResource("invoice.xsd"));

		return unmarshaller;
	}

	@Bean
	public InvoiceClientServiceImpl client() {
		logger.debug("In client()...");
		InvoiceClientServiceImpl client = new InvoiceClientServiceImpl();

		client.setWebServiceTemplate(webServiceTemplate());

		return client;
	}

	@Bean
	public XsdSchema invoiceSchema() {
		logger.debug("In invoiceSchema()...");

		return new SimpleXsdSchema(new ClassPathResource("invoice.xsd"));
	}

	@Bean
	public MarshallingHttpMessageConverter marshallingConverter() {
		logger.debug("In marshallingConverter()...");

		return new MarshallingHttpMessageConverter(marshaller(), unmarshaller());
	}

	@Bean
	public Wss4jSecurityInterceptor wsClientSecurityInterceptor() {
		logger.debug("In wsClientSecurityInterceptor()...");
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();

		configureValidation(securityInterceptor);
		configureSecurement(securityInterceptor);

		return securityInterceptor;
	}

	/**
	 * Sets validation actions to interceptor.
	 * 
	 * @param securityInterceptor
	 */
	private void configureValidation(Wss4jSecurityInterceptor securityInterceptor) {
		try {
			securityInterceptor.setValidationActions("Timestamp Signature Encrypt");

			securityInterceptor.setTimestampStrict(true);
			securityInterceptor.setValidationTimeToLive(10);
			securityInterceptor.setFutureTimeToLive(10);

			securityInterceptor.setEnableSignatureConfirmation(true);

			securityInterceptor.setValidationSignatureCrypto(keyStore().getObject());
			securityInterceptor.setValidationDecryptionCrypto(keyStore().getObject());
			securityInterceptor.setValidationCallbackHandler(validationCallbackHandler());
		} catch (Exception e) {
			logger.debug("!!! Error setting validation crypto !!!");
			logger.debug("!!! Error message: {}", e.getMessage());
			e.printStackTrace();
		}
	}

	@Bean
	public KeyStoreCallbackHandler validationCallbackHandler() {
		KeyStoreCallbackHandler validationCallbackHandler = new KeyStoreCallbackHandler();
		validationCallbackHandler.setPrivateKeyPassword("bank1_pass");

		return validationCallbackHandler;
	}

	/**
	 * Sets securement actions to interceptor.
	 * 
	 * @param securityInterceptor
	 */
	private void configureSecurement(Wss4jSecurityInterceptor securityInterceptor) {
		try {
			securityInterceptor.setSecurementActions("Timestamp Signature Encrypt");

			securityInterceptor.setSecurementEncryptionKeyIdentifier("IssuerSerial");
			securityInterceptor.setSecurementEncryptionKeyTransportAlgorithm("http://www.w3.org/2001/04/xmlenc#rsa-1_5");
			securityInterceptor.setSecurementEncryptionSymAlgorithm("http://www.w3.org/2001/04/xmlenc#aes128-cbc");

			securityInterceptor.setSecurementTimeToLive(10);
			securityInterceptor.setTimestampPrecisionInMilliseconds(true);
			securityInterceptor.setTimestampStrict(true);

			securityInterceptor.setSecurementUsername("bank1");
			securityInterceptor.setSecurementPassword("bank1_pass");
			securityInterceptor.setSecurementSignatureCrypto(keyStore().getObject());

			securityInterceptor.setSecurementEncryptionUser("bank2");
			securityInterceptor.setSecurementEncryptionCrypto(keyStore().getObject());
			securityInterceptor.setSecurementEncryptionParts("{Content}{http://localhost:8080/invoice/schema}SendInvoiceRequest");
		} catch (Exception e) {
			logger.debug("!!! Error setting signature crypto !!!");
			logger.debug("!!! Error message: {}", e.getMessage());
			e.printStackTrace();
		}
	}

	@Bean
	public CryptoFactoryBean keyStore() throws IOException {
		logger.debug("In keyStore()...");
		CryptoFactoryBean signatureCrypto = new CryptoFactoryBean();
		signatureCrypto.setKeyStoreLocation(new ClassPathResource("/security/keys/bank1.jks"));
		signatureCrypto.setKeyStorePassword("bank1_pass");

		return signatureCrypto;
	}

}
