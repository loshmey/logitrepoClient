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
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.security.support.KeyStoreFactoryBean;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.callback.KeyStoreCallbackHandler;
import org.springframework.ws.soap.security.wss4j.support.CryptoFactoryBean;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.lo.apps.ws.client.service.impl.InvoiceClientServiceImpl;

@EnableWs
@Configuration
public class ClientWSConfiguration extends WsConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ClientWSConfiguration.class);

    @Bean(name = "messageFactory")
    public SaajSoapMessageFactory messageFactory(){
        return new SaajSoapMessageFactory();
    }

    @Bean(name = "messageSender")
    public HttpComponentsMessageSender messageSender(){
        return new HttpComponentsMessageSender();
    }

	@Bean(name = "webServiceTemplate")
	public WebServiceTemplate webServiceTemplate() throws Exception {
		logger.debug("In webServiceTemplate()...");

		WebServiceTemplate wsTemplate = new WebServiceTemplate(messageFactory());
		ClientInterceptor[] interceptors = { wsClientSecurityInterceptor() };

		wsTemplate.setDefaultUri("http://localhost:8080/services");
		wsTemplate.setMarshaller(marshaller());
		wsTemplate.setUnmarshaller(marshaller());
        wsTemplate.setMessageSender(messageSender());
        wsTemplate.setInterceptors(interceptors);

        return wsTemplate;
	}

	@Bean(name = "invoice")
	public DefaultWsdl11Definition defaultWsdl11Definition() {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

		wsdl11Definition.setPortTypeName("Invoice");
		wsdl11Definition.setLocationUri("/services");
        wsdl11Definition.setTargetNamespace("http://localhost:8080/invoice/schema");
        wsdl11Definition.setSchema(invoiceSchema());

		return wsdl11Definition;
	}

	@Bean(name = "marshaller")
	public Jaxb2Marshaller marshaller() {
		logger.debug("In marshaller()...");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.lo.apps.ws.client.entity.invoice");
		marshaller.setSchema(new ClassPathResource("invoice.xsd"));

		return marshaller;
	}

	@Bean(name = "client")
	public InvoiceClientServiceImpl client() throws Exception {
		logger.debug("In client()...");
		InvoiceClientServiceImpl client = new InvoiceClientServiceImpl();

		client.setWebServiceTemplate(webServiceTemplate());

		return client;
	}

	@Bean(name = "invoiceSchema")
	public XsdSchema invoiceSchema() {
		logger.debug("In invoiceSchema()...");

		return new SimpleXsdSchema(new ClassPathResource("invoice.xsd"));
	}

//	@Bean
//	public MarshallingHttpMessageConverter marshallingConverter() {
//		logger.debug("In marshallingConverter()...");
//
//		return new MarshallingHttpMessageConverter(marshaller(), marshaller());
//	}

	@Bean
	public Wss4jSecurityInterceptor wsClientSecurityInterceptor() throws Exception {
		logger.debug("In wsClientSecurityInterceptor()...");
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();

		//configureValidation(securityInterceptor);
		//configureSecurement(securityInterceptor);

        // securement
//        securityInterceptor.setSecurementActions("Timestamp Signature Encrypt");
		securityInterceptor.setSecurementActions("Timestamp");
        securityInterceptor.setTimestampPrecisionInMilliseconds(true);
        securityInterceptor.setSecurementTimeToLive(999999999);
        securityInterceptor.setSecurementUsername("firma1");
        securityInterceptor.setSecurementPassword("x");
        securityInterceptor.setSecurementSignatureCrypto(keyStore().getObject());
        securityInterceptor.setSecurementEncryptionCrypto(keyStore().getObject());
        securityInterceptor.setSecurementEncryptionParts("{Content}{http://localhost:8080/invoice/schema}SendInvoiceRequest");
        securityInterceptor.setSecurementEncryptionUser("banka1");

        // validation
//        securityInterceptor.setValidationActions("Signature");
        securityInterceptor.setValidationActions("Timestamp");
        securityInterceptor.setTimestampStrict(true);
        securityInterceptor.setValidationTimeToLive(999999999);
        securityInterceptor.setValidationSignatureCrypto(keyStore().getObject());

		return securityInterceptor;
	}

	/**
	 * Sets validation actions to interceptor.
	 * 
	 * @param //securityInterceptor
	 */
	/*private void configureValidation(Wss4jSecurityInterceptor securityInterceptor) {
		try {
            securityInterceptor.setValidateRequest(true);
            securityInterceptor.setValidateResponse(true);
			securityInterceptor.setValidationActions("Signature Encrypt Timestamp");

            securityInterceptor.setValidationSignatureCrypto(keyStore().getObject());
            securityInterceptor.setValidationDecryptionCrypto(keyStore().getObject());
            securityInterceptor.setValidationCallbackHandler(validationCallbackHandler());

			securityInterceptor.setTimestampStrict(true);
			securityInterceptor.setValidationTimeToLive(10);
			securityInterceptor.setFutureTimeToLive(10);

			securityInterceptor.setEnableSignatureConfirmation(true);
		} catch (Exception e) {
			logger.debug("!!! Error setting validation crypto !!!");
			logger.debug("!!! Error message: {}", e.getMessage());
			e.printStackTrace();
		}
	}*/

	@Bean
	public KeyStoreCallbackHandler validationCallbackHandler() {
		KeyStoreCallbackHandler validationCallbackHandler = new KeyStoreCallbackHandler();
		validationCallbackHandler.setPrivateKeyPassword("x");

		return validationCallbackHandler;
	}

	/**
	 * Sets securement actions to interceptor.
	 * 
	 * @param //securityInterceptor
	 */
	/*private void configureSecurement(Wss4jSecurityInterceptor securityInterceptor) {
		try {
            securityInterceptor.setSecureResponse(true);
			securityInterceptor.setSecurementActions("Timestamp Signature Encrypt");

			securityInterceptor.setSecurementEncryptionKeyIdentifier("IssuerSerial");
			securityInterceptor.setSecurementEncryptionKeyTransportAlgorithm("http://www.w3.org/2001/04/xmlenc#rsa-1_5");
			securityInterceptor.setSecurementEncryptionSymAlgorithm("http://www.w3.org/2001/04/xmlenc#aes128-cbc");

			securityInterceptor.setTimestampStrict(true);
            securityInterceptor.setSecurementTimeToLive(10);

            securityInterceptor.setSecurementSignatureKeyIdentifier("IssuerSerial");
            securityInterceptor.setSecurementUsername("firma1");
            securityInterceptor.setSecurementPassword("x");
			securityInterceptor.setSecurementSignatureCrypto(keyStore().getObject());
            securityInterceptor.setSecurementSignatureParts("{Content}{http://localhost:8080/invoice/schema}SendInvoiceRequest");

			securityInterceptor.setSecurementEncryptionUser("banka1");
			securityInterceptor.setSecurementEncryptionCrypto(keyStore().getObject());
			securityInterceptor.setSecurementEncryptionParts("{Content}{http://localhost:8080/invoice/schema}SendInvoiceRequest");
		} catch (Exception e) {
			logger.debug("!!! Error setting signature crypto !!!");
			logger.debug("!!! Error message: {}", e.getMessage());
			e.printStackTrace();
		}
	}*/

    /**
     * Crypto Factory Bean configuration.
     * @return configured keystore
     * @throws IOException
     */
	@Bean
	public CryptoFactoryBean keyStore() throws IOException {
		logger.debug("In keyStore()...");
		CryptoFactoryBean signatureCrypto = new CryptoFactoryBean();
		signatureCrypto.setKeyStorePassword("x");
		signatureCrypto.setKeyStoreLocation(new ClassPathResource("/security/keystore/firma1.jks"));

		return signatureCrypto;
	}

    @Bean
    public KeyStoreCallbackHandler keyStoreCallbackHandler() {
        KeyStoreCallbackHandler keyStoreCallbackHandler = new KeyStoreCallbackHandler();
        keyStoreCallbackHandler.setKeyStore(keyStoreFactoryBean().getObject());
        keyStoreCallbackHandler.setPrivateKeyPassword("x");

        return keyStoreCallbackHandler;
    }

    @Bean
    public KeyStoreFactoryBean keyStoreFactoryBean(){
        KeyStoreFactoryBean keyStore = new KeyStoreFactoryBean();
        keyStore.setLocation(new ClassPathResource("/security/keystore/firma1.jks"));
        keyStore.setPassword("x");

        return keyStore;
    }

}
