package com.firetruckbowl.tgirest.resource;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
   * @param httpHeaders injected by the Servlet, gives access to HTTP headers from the request
   *    and might be useful for checking things like Accepted Language, etc.
   * @return the class' documentation
   */
  @OPTIONS
  Response getDocumentation(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders);
}
