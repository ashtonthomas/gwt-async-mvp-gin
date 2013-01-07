package io.ashton.async.client.app;

import io.ashton.async.client.app.ioc.AppInjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class AppLauncher implements EntryPoint {
  private final AppInjector injector = GWT.create(AppInjector.class);

  @Override
  public void onModuleLoad() {
    injector.getApp().run();
  }

}
