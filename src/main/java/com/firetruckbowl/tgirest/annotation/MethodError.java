package com.firetruckbowl.tgirest.annotation;

import javax.ws.rs.core.Response;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodError {

  /**
   * The HTTP status code for the occurring error.
   * @return
   */
  Response.Status status();

  /**
   * A human friendly message indicating why this error occured.
   * @return
   */
  String cause();
}
