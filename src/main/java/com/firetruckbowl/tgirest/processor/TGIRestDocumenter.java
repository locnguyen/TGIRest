package com.firetruckbowl.tgirest.processor;


import com.firetruckbowl.tgirest.annotation.MethodError;
import com.firetruckbowl.tgirest.annotation.ResourceDoc;
import com.firetruckbowl.tgirest.annotation.ResourceMethod;
import com.firetruckbowl.tgirest.model.MethodDocument;
import com.firetruckbowl.tgirest.model.ResourceDocument;
import com.firetruckbowl.tgirest.model.ResponseError;
import com.firetruckbowl.tgirest.resource.Documented;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * Processes TGIRest annotations and generates documentation.
 *
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
public class TGIRestDocumenter implements Documenter {
  private static final Logger LOG = LoggerFactory.getLogger(TGIRestDocumenter.class);

  @Override
  public ResourceDocument generateResourceDocument(@Context UriInfo uriInfo, Documented resource) {

    if (!resource.getClass().isAnnotationPresent(ResourceDoc.class)) {
      throw new RuntimeException("Cannot generate documentation for a resource class"
          + "that is not annotated with @ResoureceDoc");
    }

    ResourceDocument rd = new ResourceDocument();

    for (Method m : resource.getClass().getMethods()) {

    }

    return rd;
  }

  @Override
  public MethodDocument generateMethodDocument(@Context UriInfo uriInfo, Method method) {
    MethodDocument md = new MethodDocument();

    // --- Process JAX-RS annotations
    Path path = method.getAnnotation(Path.class);
    if (path != null) {
      md.setPath(uriInfo.getBaseUri().toString() + path.value());
    }

    md.setHttpMethod(getHttpMethod(method));

    Produces produces = method.getAnnotation(Produces.class);
    if (produces != null) {
      md.setMediaTypesProduced(produces.value());
    }

    Consumes consumes = method.getAnnotation(Consumes.class);
    if (consumes != null) {
      md.setMediaTypesConsumed(consumes.value());
    }

    // Gets a 2-D array of params, and each param has an array of annotations
    Annotation[][] methodPrams = method.getParameterAnnotations();
    List<String> queryParamList = new ArrayList<String>();

    if (methodPrams != null && methodPrams.length > 0) {
      for (int i = 0; i < methodPrams.length; i ++) {
        for (Annotation a: methodPrams[i]) {
          if (a.annotationType() == QueryParam.class) {
            QueryParam qp = (QueryParam) a;
            queryParamList.add(qp.value());
          }
        }
        md.setQueryParams(queryParamList);
      }
    }


    // --- Process TGIRest annotations
    ResourceMethod resourceMethod = method.getAnnotation(ResourceMethod.class);
    if (resourceMethod != null) {
      md.setStatus(resourceMethod.status().getStatusCode());

      md.setDescription(resourceMethod.description());

      md.setResponseErrors(getResponseErrors(resourceMethod));

      md.setLanguages(resourceMethod.languages());
    }

    return md;
  }

  /**
   * Determines the HTTP method the method is annotated with.
   *
   * @param method the resource method to check the HTTP method for
   * @return the HTTP method
   */
  public String getHttpMethod(Method method) {
    String httpMethod = "";

    if (method.getAnnotations().length > 0) {
      for (Annotation a : method.getAnnotations()) {
        if (a.annotationType().isAnnotationPresent(HttpMethod.class)) {
          httpMethod = a.annotationType().getAnnotation(HttpMethod.class).value();
          break;
        }
      }
    }

    return httpMethod;
  }

  public List<ResponseError> getResponseErrors(ResourceMethod resourceMethod) {
    List<ResponseError> errors = new ArrayList<ResponseError>();

    if (resourceMethod != null) {
      MethodError[] methodErrors = resourceMethod.errors();

      if (methodErrors.length > 0) {
        for (MethodError methodError: methodErrors) {
          ResponseError e = new ResponseError();
          e.setStatus(methodError.status().getStatusCode());
          e.setCause(methodError.cause());
          errors.add(e);
        }
      }
    }

    return errors;
  }
}
