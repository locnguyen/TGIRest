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
public @interface ResourceMethod {

  /**
   * A description of how this endpoint changes the state of the resource.
   * @return
   */
  String description();

  /**
   * The HTTP status that that a successful invocation will return.
   *
   * @return
   */
  Response.Status status();

  /**
   * An array of error codes this method can return and an explanation of each.
   *
   * @return
   */
  MethodError[] errors();
}
