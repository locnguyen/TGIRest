package com.firetruckbowl.tgirest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Languages {

  /**
   * An array of languages a resource or resource method supports.
   *
   * @return
   */
  String[] value() default {};
}
