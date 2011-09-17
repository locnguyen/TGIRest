package com.firetruckbowl.tgirest.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@XmlRootElement(name = "ResourceDocument")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceDocument {

  @XmlElement(name = "Path")
  private String path;

  @XmlElement(name = "Description")
  private String description;

  @XmlElementWrapper(name = "MethodDocuments")
  @XmlElement(name = "MethodDocument")
  private List<MethodDocument> methodDocuments;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<MethodDocument> getMethodDocuments() {
    return methodDocuments;
  }

  public void setMethodDocuments(List<MethodDocument> methodDocuments) {
    this.methodDocuments = methodDocuments;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
