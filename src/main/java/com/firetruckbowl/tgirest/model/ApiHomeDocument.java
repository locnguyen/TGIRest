package com.firetruckbowl.tgirest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@XmlRootElement(name = "ApiHomeDocument")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApiHomeDocument extends ResourceDocument {

  @XmlElement(name = "ApiName")
  private String apiName;

  @XmlElement(name = "ApiDescription")
  private String apiDescription;

  @XmlElement(name = "ApiOwner")
  private String apiOwner;

  @XmlElement(name = "ApiContactEmail")
  private String apiContactEmail;

  @XmlElement(name = "ConnegType")
  private String connegType;

  public String getApiName() {
    return apiName;
  }

  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  public String getApiDescription() {
    return apiDescription;
  }

  public void setApiDescription(String apiDescription) {
    this.apiDescription = apiDescription;
  }

  public String getApiOwner() {
    return apiOwner;
  }

  public void setApiOwner(String apiOwner) {
    this.apiOwner = apiOwner;
  }

  public String getApiContactEmail() {
    return apiContactEmail;
  }

  public void setApiContactEmail(String apiContactEmail) {
    this.apiContactEmail = apiContactEmail;
  }

  public String getConnegType() {
    return connegType;
  }

  public void setConnegType(String connegType) {
    this.connegType = connegType;
  }
}
