package com.firetruckbowl.tgirest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@XmlRootElement(name = "ResponseError")
public class ResponseError {

  @XmlElement(name = "Status")
  private int status;

  @XmlElement(name = "Cause")
  private String cause;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }
}
