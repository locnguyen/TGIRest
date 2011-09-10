package com.firetruckbowl.tgirest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
  @XmlElementWrapper(name = "ResponseErrors")
  @XmlElement(name = "ResponseError")
  private List<ResponseError> responseErrors;

  /* A description of what this method does */
  @XmlElement(name = "Description")
  private String description;

  /* An array of media types this method can produce (YAML, JSON, XML etc) */
  @XmlElementWrapper(name = "MediaTypesProduced")
  private String[] mediaTypesProduced;

  /* An array of media types this method can consume */
  @XmlElementWrapper(name = "MediaTypesConsumed")
  private String[] mediaTypesConsumed;

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

  public String[] getMediaTypesProduced() {
    return mediaTypesProduced;
  }

  public void setMediaTypesProduced(String[] mediaTypesProduced) {
    this.mediaTypesProduced = mediaTypesProduced;
  }

  public String[] getMediaTypesConsumed() {
    return mediaTypesConsumed;
  }

  public void setMediaTypesConsumed(String[] mediaTypesConsumed) {
    this.mediaTypesConsumed = mediaTypesConsumed;
  }
}
