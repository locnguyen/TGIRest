package com.firetruckbowl.tgirest.processor;

import com.firetruckbowl.tgirest.annotation.MethodError;
import com.firetruckbowl.tgirest.annotation.ParamNote;
import com.firetruckbowl.tgirest.annotation.ResourceMethod;
import com.firetruckbowl.tgirest.model.MethodDocument;
import com.firetruckbowl.tgirest.model.ParamDocument;
import com.firetruckbowl.tgirest.resource.Documented;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@RunWith(JUnit4.class)
public class ProcessMethodParams {

  private MethodParamProcessor systemUnderTest;

  private MethodDocument document;

  @Before
  public void setUp() {
    systemUnderTest = new MethodParamProcessor();
    document = new MethodDocument();
  }

  @Test
  @SuppressWarnings("")
  public void shouldGetQueryParamDocs() throws Exception {
    // given
    FooResource resource = new FooResource();
    Method m = resource.getClass().getMethod("getBar", String.class, String.class, String.class);

    // when
    systemUnderTest.processAnnotations(m, document);

    // then
    List<ParamDocument> queryParams = Arrays.asList(document.getQueryParams());

    ParamDocument qpt = new ParamDocument("t", "The time");
    ParamDocument qpl = new ParamDocument("l", "The location");

    assertThat(queryParams, hasItems(qpt, qpl));
  }

  @Test
  @SuppressWarnings("")
  public void shouldGetPathParamDocs() throws Exception {
    // given
    FooResource resource = new FooResource();
    Method m = resource.getClass().getMethod("getBar", String.class, String.class, String.class);

    // when
    systemUnderTest.processAnnotations(m, document);

    // then
    List<ParamDocument> pathParams = Arrays.asList(document.getPathParams());
    assertThat(pathParams, hasItems(new ParamDocument("id", "The ID of the bar")));
  }

  /**
   * A class for use with testing only since we don't want to rely on the
   * library's actual resource classes staying the same.
   */
  @Path("foo")
  class FooResource implements Documented {

    @GET
    @Path("bar/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ResourceMethod(
      status = Response.Status.OK,
      description = "bar method",
      errors = {
        @MethodError(status = Response.Status.NOT_FOUND, cause = "The bar could not be found")
      }
    )
    public Response getBar(@PathParam("id")
                           @ParamNote("The ID of the bar") String id,
                           @QueryParam("t")
                           @ParamNote("The time") String time,
                           @QueryParam("l")
                           @ParamNote("The location") String location) {
      return Response.status(Response.Status.OK).build();
    }

    @Override
    public Response getDocumentation(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
      /* no-op */
      return null;
    }
  }
}
