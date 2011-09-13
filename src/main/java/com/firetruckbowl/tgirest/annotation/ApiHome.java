package com.firetruckbowl.tgirest.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiHome {

  /**
   * The identifying name of your API. Required so the API
   * documentation can be identified by a human friendly name.
   *
   * @return your API's name
   */
  String apiName();

  /**
   * A brief description of your API's raison d'detre. Required to
   * produce useful documentation.
   *
   * @return your API description
   */
  String apiDescription();

  /**
   * The API's owning entity - person, company, org etc.
   *
   * @return the API owner
   */
  String apiOwner() default "";

  /**
   * The API's point of contact whom everyone can bug :)
   *
   * @return a support e-mail address
   */
  String apiContactEmail() default "";

}
