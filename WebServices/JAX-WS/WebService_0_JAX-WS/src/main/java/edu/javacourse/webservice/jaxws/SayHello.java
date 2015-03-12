package edu.javacourse.webservice.jaxws;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "sayHello", namespace = "http://webservice.javacourse.edu/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sayHello", namespace = "http://webservice.javacourse.edu/")
public class SayHello {

    @XmlElement(name = "arg0", namespace = "")
    private String arg0;

    /**
     * @return returns String
     */
    public String getArg0() {
        return this.arg0;
    }

    /**
     * @param arg0 the value for the arg0 property
     */
    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

}
