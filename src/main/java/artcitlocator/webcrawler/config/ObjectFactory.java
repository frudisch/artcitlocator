//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.03.10 um 01:35:43 PM CET 
//


package artcitlocator.webcrawler.config;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the artcitlocator.webcrawler.data package. 
 * <p>An ObjectFactory allows you to programmatically 
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

    private final static QName _CrawlerConfigCrawlerSeed_QNAME = new QName("", "seed");
    private final static QName _CrawlerConfigCrawlerPattern_QNAME = new QName("", "pattern");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artcitlocator.webcrawler.config
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrawlerConfig }
     * 
     */
    public CrawlerConfig createCrawlerConfig() {
        return new CrawlerConfig();
    }

    /**
     * Create an instance of {@link CrawlerConfig.Crawler }
     * 
     */
    public CrawlerConfig.Crawler createCrawlerConfigCrawler() {
        return new CrawlerConfig.Crawler();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seed", scope = CrawlerConfig.Crawler.class)
    public JAXBElement<String> createCrawlerConfigCrawlerSeed(String value) {
        return new JAXBElement<String>(_CrawlerConfigCrawlerSeed_QNAME, String.class, CrawlerConfig.Crawler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pattern", scope = CrawlerConfig.Crawler.class)
    public JAXBElement<String> createCrawlerConfigCrawlerPattern(String value) {
        return new JAXBElement<String>(_CrawlerConfigCrawlerPattern_QNAME, String.class, CrawlerConfig.Crawler.class, value);
    }

}
