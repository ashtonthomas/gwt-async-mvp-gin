package io.ashton.async.client.app.ioc;

import io.ashton.async.client.app.activity.AppActivityMapper;
import io.ashton.async.client.app.activity.AppActivityMapper.ActivityFactory;
import io.ashton.async.client.app.activity.HomeActivity;
import io.ashton.async.client.app.ioc.provider.ActivityManagerProvider;
import io.ashton.async.client.app.ioc.provider.PlaceControllerProvider;
import io.ashton.async.client.app.ioc.provider.PlaceHistoryHandlerProvider;
import io.ashton.async.client.app.place.AppPlaceHistoryMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Singleton;

public class AppInjectorModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);
    bind(ActivityManager.class).toProvider(ActivityManagerProvider.class).in(Singleton.class);
    bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).in(Singleton.class);

//    bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
//    bind(WorkView.class).to(WorkViewImpl.class).in(Singleton.class);

    // I want these to be singletons
    bind(AppActivityMapper.class).in(Singleton.class);
    bind(AppPlaceHistoryMapper.class).in(Singleton.class);

    install(new GinFactoryModuleBuilder()
      .implement(HomeActivity.class, HomeActivity.class)
//      .implement(WorkActivity.class, WorkActivity.class) // Commented out to test CodeSplitting Dependency
      .build(ActivityFactory.class));
  }

}
