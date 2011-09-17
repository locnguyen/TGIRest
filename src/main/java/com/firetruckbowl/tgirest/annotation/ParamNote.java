package com.firetruckbowl.tgirest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamNote {

  /**
   * A brief description of the annotated query or path parameter.
   *
   * @return the parameter description
   */
  String value() default "";
}
