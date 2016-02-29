
package https.github_com.tracee.tracee.examples.jaxws.service.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.github_com.tracee.tracee.examples.jaxws.service.wsdl package. 
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

    private final static QName _SubParameters_QNAME = new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "subParameters");
    private final static QName _MulParameters_QNAME = new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "mulParameters");
    private final static QName _AddParameters_QNAME = new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "addParameters");
    private final static QName _CalculationResponse_QNAME = new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "calculationResponse");
    private final static QName _DivParameters_QNAME = new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "divParameters");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.github_com.tracee.tracee.examples.jaxws.service.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MulParameters }
     * 
     */
    public MulParameters createMulParameters() {
        return new MulParameters();
    }

    /**
     * Create an instance of {@link AddParameters }
     * 
     */
    public AddParameters createAddParameters() {
        return new AddParameters();
    }

    /**
     * Create an instance of {@link DivParameters }
     * 
     */
    public DivParameters createDivParameters() {
        return new DivParameters();
    }

    /**
     * Create an instance of {@link SubParameters }
     * 
     */
    public SubParameters createSubParameters() {
        return new SubParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://github.com/tracee/tracee/examples/jaxws/service/wsdl", name = "subParameters")
    public JAXBElement<SubParameters> createSubParameters(SubParameters value) {
        return new JAXBElement<SubParameters>(_SubParameters_QNAME, SubParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MulParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://github.com/tracee/tracee/examples/jaxws/service/wsdl", name = "mulParameters")
    public JAXBElement<MulParameters> createMulParameters(MulParameters value) {
        return new JAXBElement<MulParameters>(_MulParameters_QNAME, MulParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://github.com/tracee/tracee/examples/jaxws/service/wsdl", name = "addParameters")
    public JAXBElement<AddParameters> createAddParameters(AddParameters value) {
        return new JAXBElement<AddParameters>(_AddParameters_QNAME, AddParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://github.com/tracee/tracee/examples/jaxws/service/wsdl", name = "calculationResponse")
    public JAXBElement<Double> createCalculationResponse(Double value) {
        return new JAXBElement<Double>(_CalculationResponse_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://github.com/tracee/tracee/examples/jaxws/service/wsdl", name = "divParameters")
    public JAXBElement<DivParameters> createDivParameters(DivParameters value) {
        return new JAXBElement<DivParameters>(_DivParameters_QNAME, DivParameters.class, null, value);
    }

}
