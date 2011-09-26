package com.firetruckbowl.tgirest.processor;

import com.firetruckbowl.tgirest.annotation.ParamNote;
import com.firetruckbowl.tgirest.model.MethodDocument;
import com.firetruckbowl.tgirest.model.ParamDocument;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Processes annotations for the parameters of a method
 *
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
public class MethodParamProcessor {

  /**
   * Processes annotations for each parameter in the method's signature.
   *
   * @param method the method to inspect
   * @param document the document to save the annotation data to
   * @return an updated MethoDocument object
   */
  public MethodDocument processAnnotations(Method method, MethodDocument document) {
    // Gets a 2-D array of params, and each param has an array of annotations
    Annotation[][] methodPrams = method.getParameterAnnotations();
    List<ParamDocument> queryParamsList = new ArrayList<ParamDocument>();
    List<ParamDocument> pathParamsList = new ArrayList<ParamDocument>();

    if (methodPrams != null && methodPrams.length > 0) {
      // For each parameter of the method
      for (int i = 0; i < methodPrams.length; i ++) {
        ParamDocument pd = new ParamDocument();

        // For each annotation of the parameter check to see what type it is
        for (Annotation a: methodPrams[i]) {
          if (a.annotationType() == ParamNote.class) {
            pd.setDescription(((ParamNote) a).value());
          }
          else if (a.annotationType() == QueryParam.class) {
            pd.setName(((QueryParam) a).value());
            queryParamsList.add(pd);
          }
          else if (a.annotationType() == PathParam.class) {
            pd.setName(((PathParam) a).value());
            pathParamsList.add(pd);
          }
        }
        document.setQueryParams(queryParamsList);
        document.setPathParams(pathParamsList);
      }
    }
    return document;
  }
}
