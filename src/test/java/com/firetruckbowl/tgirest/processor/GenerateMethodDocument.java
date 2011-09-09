package com.firetruckbowl.tgirest.processor;

import com.firetruckbowl.tgirest.TGIRestWatcher;
import com.firetruckbowl.tgirest.annotation.MethodError;
import com.firetruckbowl.tgirest.annotation.ResourceMethod;
import com.firetruckbowl.tgirest.model.MethodDocument;
import com.firetruckbowl.tgirest.resource.Documented;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.Method;
import java.net.URI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
@RunWith(JUnit4.class)
public class GenerateMethodDocument {
  private final String BASE_URI = "http://winterfel.com/api/";

  @Rule
  public TestRule watcher = new TGIRestWatcher();

  @Mock
  private UriInfo uriInfo;

  private Documenter systemUnderTest;

  @Before
  public void setUp() throws Exception {
    initMocks(this);
    URI baseUri = new URI(BASE_URI);
    given(uriInfo.getBaseUri()).willReturn(baseUri);

    systemUnderTest = new TGIRestDocumenter();
  }

  @Test
  @SuppressWarnings("")
  public void shouldGetPath() throws Exception {
    // given
    FooResource resource = new FooResource();
    Method m = resource.getClass().getMethod("getBar", String.class);

    // when
    MethodDocument document =  systemUnderTest.generateMethodDocument(uriInfo, m);

    // then
    assertThat(document.getPath(), is(BASE_URI + "bar/{id}"));
  }

  @Test
  @SuppressWarnings("")
  public void shouldGetHttpMethod() throws Exception {
    // given
    FooResource resource = new FooResource();
    Method m = resource.getClass().getMethod("getBar", String.class);

    // when
    MethodDocument document = systemUnderTest.generateMethodDocument(uriInfo, m);

    // then
    assertThat(document.getHttpMethod(), is("GET"));
  }

  @Test
  @SuppressWarnings("")
  public void shouldGetSuccessStatus() throws Exception {
    // given
    FooResource resource = new FooResource();
    Method m = resource.getClass().getMethod("getBar", String.class);

    // when
    MethodDocument document = systemUnderTest.generateMethodDocument(uriInfo, m);

    // then
    assertThat(document.getStatus(), is(Response.Status.OK.getStatusCode()));
  }

  @Test
  @SuppressWarnings("")
  public void shouldGetDescription() throws Exception {
    // given
    FooResource resource = new FooResource();
    Method m = resource.getClass().getMethod("getBar", String.class);

    // when
    MethodDocument document = systemUnderTest.generateMethodDocument(uriInfo, m);

    // then
    assertThat(document.getDescription(), is("bar method"));
  }

  @Test
  @SuppressWarnings("")
  public void shouldGetErrors() throws Exception {
    // given
    FooResource resource = new FooResource();
    Method m = resource.getClass().getMethod("getBar", String.class);

    // when
    MethodDocument document = systemUnderTest.generateMethodDocument(uriInfo, m);

    // then
    assertThat(document.getResponseErrors().size(), is(1));
    assertThat(document.getResponseErrors().get(0).getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));
  }

  /**
   * A class for use with testing only since we don't want to rely on the
   * library's actual resource classes staying the same.
   */
  @Path("foo")
  class FooResource implements Documented {

    @GET
    @Path("bar/{id}")
    @ResourceMethod(
      status = Response.Status.OK,
      description = "bar method",
      errors = {
        @MethodError(status = Response.Status.NOT_FOUND, cause = "The bar could not be found")
    })
    public Response getBar(@PathParam("id") String id) {
      return Response.status(Response.Status.OK).build();
    }

    @Override
    public Response getDocumentation(@Context UriInfo uriInfo) {
      /* no-op */
      return null;
    }
  }
}
