package com.firetruckbowl.tgirest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MethodDocument")
public class MethodDocument {

  /* The URI for this operation */
  @XmlElement(name = "Path")
  private String path;

  /* The HTTP method this operation supports */
  @XmlElement(name = "HttpMethod")
  private String httpMethod;

  /* The HTTP status if this operation is invoked successfully */
  @XmlElement(name = "Status")
  private int status;

  /* A list of possible responseErrors this operation could experience */
  private List<ResponseError> responseErrors;

  /* A description of what this method does */
  private String description;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getHttpMethod() {
    return httpMethod;
  }

  public void setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public List<ResponseError> getResponseErrors() {
    return responseErrors;
  }

  public void setResponseErrors(List<ResponseError> responseErrors) {
    this.responseErrors = responseErrors;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
