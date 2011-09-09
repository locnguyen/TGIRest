package com.firetruckbowl.tgirest.processor;

import com.firetruckbowl.tgirest.model.MethodDocument;
import com.firetruckbowl.tgirest.model.ResourceDocument;
import com.firetruckbowl.tgirest.resource.Documented;

import javax.ws.rs.core.UriInfo;
import java.lang.reflect.Method;

/**
 * Processes TGIRest annotations and generates documentation.
 *
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
public interface Documenter {

  /**
   * Generates a ResourceDocument from the Documented object by processing
   * its annotations.
   *
   * @param resource the resource class to document
   * @return the documentation of the resource
   */
  ResourceDocument generateResourceDocument(UriInfo uriInfo, Documented resource);

  /**
   * Generates a MethodDocument from the given Method by processing its
   * annotations.
   *
   * @param method the method of a resource class to document
   * @return the documentation for a method
   */
  MethodDocument generateMethodDocument(UriInfo uriInfo, Method method);
}
