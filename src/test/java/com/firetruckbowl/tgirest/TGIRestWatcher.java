package com.firetruckbowl.tgirest;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:lochnguyen@gmail.com">Loc Nguyen</a>
 */
public class TGIRestWatcher extends TestWatcher {
  private static final Logger LOG = LoggerFactory.getLogger(TGIRestWatcher.class);

  @Override
  protected void succeeded(Description description) {
    LOG.info(description.getDisplayName() + ": success!\n");
  }

  @Override
  protected void failed(Throwable e, Description description) {
    LOG.info(description.getDisplayName() + ": failure!\n");
  }
}
