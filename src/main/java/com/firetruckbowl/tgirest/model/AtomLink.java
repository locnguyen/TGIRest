package com.firetruckbowl.tgirest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Provides a means of navigation between resources.
 *
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@XmlRootElement(name = "Link", namespace = "http://www.w3.org/2005/Atom")
@XmlAccessorType(XmlAccessType.FIELD)
public class AtomLink {

  /* The link's uri */
  @XmlElement(name = "href")
  private String href;

  /* Indicates the type of the link */
  @XmlElement(name = "rel")
  private String rel;

  /* A human friendly title for the link */
  @XmlElement(name = "title")
  private String title;

  /* The media type of the resource representation this link will return */
  @XmlElement(name = "type")
  private String type;

  /* The language of resource representation */
  @XmlElement(name = "hreflang")
  private String hreflang;

  /* The content length of the representation */
  @XmlElement(name = "length")
  private String length;

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getRel() {
    return rel;
  }

  public void setRel(String rel) {
    this.rel = rel;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getHreflang() {
    return hreflang;
  }

  public void setHreflang(String hreflang) {
    this.hreflang = hreflang;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }
}
