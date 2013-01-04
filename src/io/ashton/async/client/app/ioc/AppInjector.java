package io.ashton.async.client.app.ioc;

import io.ashton.async.client.app.Application;

import com.google.gwt.inject.client.GinModules;

@GinModules(AppInjectorModule.class)
public interface AppInjector {

  Application getApp();
}
