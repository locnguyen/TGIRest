package com.firetruckbowl.tgirest.resource;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Provides an interface for top level resources to return their
 * documentation when OPTIONS is issued to the implementing
 * class' path.
 *
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
public interface Documented {

  /**
   *
   * @param uriInfo injected by the Servlet, provides information useful for building URIs
   * @return the class' documentation
   */
  @OPTIONS
  Response getDocumentation(@Context UriInfo uriInfo);
}
