
package com.lo.apps.ws.client.entity.invoice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendInvoiceRequest }
     * 
     */
    public SendInvoiceRequest createSendInvoiceRequest() {
        return new SendInvoiceRequest();
    }

    /**
     * Create an instance of {@link Invoice }
     * 
     */
    public Invoice createInvoice() {
        return new Invoice();
    }

    /**
     * Create an instance of {@link InvoiceHeader }
     * 
     */
    public InvoiceHeader createInvoiceHeader() {
        return new InvoiceHeader();
    }

    /**
     * Create an instance of {@link InvoiceRecord }
     * 
     */
    public InvoiceRecord createInvoiceRecord() {
        return new InvoiceRecord();
    }

    /**
     * Create an instance of {@link SendInvoiceResponse }
     * 
     */
    public SendInvoiceResponse createSendInvoiceResponse() {
        return new SendInvoiceResponse();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link Supplier }
     * 
     */
    public Supplier createSupplier() {
        return new Supplier();
    }

    /**
     * Create an instance of {@link Buyer }
     * 
     */
    public Buyer createBuyer() {
        return new Buyer();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Sums }
     * 
     */
    public Sums createSums() {
        return new Sums();
    }

}
