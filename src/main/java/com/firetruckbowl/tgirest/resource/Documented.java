package com.firetruckbowl.tgirest.resource;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

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
  @Produces(MediaType.APPLICATION_JSON)
  Response getDocumentation(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders);
}
