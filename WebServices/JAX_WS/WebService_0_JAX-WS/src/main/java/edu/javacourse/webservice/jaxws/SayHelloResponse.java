package edu.javacourse.webservice.jaxws;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "sayHelloResponse", namespace = "http://webservice.javacourse.edu/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sayHelloResponse", namespace = "http://webservice.javacourse.edu/")
public class SayHelloResponse {

    @XmlElement(name = "return", namespace = "")
    private String _return;

    /**
     * @return returns String
     */
    public String getReturn() {
        return this._return;
    }

    /**
     * @param _return the value for the _return property
     */
    public void setReturn(String _return) {
        this._return = _return;
    }

}
