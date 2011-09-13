package com.firetruckbowl.tgirest.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceDoc {

  /**
   * A description of what this top level resource's role in the system.
   * Required so the documentation produced is useful.
   *
   * @return
   */
  String description();
}
