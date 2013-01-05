package io.ashton.async.client.app.ioc;

import io.ashton.async.client.app.Application;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(AppInjectorModule.class)
public interface AppInjector extends Ginjector{
  Application getApp();
}
