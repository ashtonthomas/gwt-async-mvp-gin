package io.ashton.async.client.app.ioc;

import io.ashton.async.client.app.activity.AppAsyncActivityMapper;
import io.ashton.async.client.app.activity.AppAsyncActivityMapper.ActivityFactory;
import io.ashton.async.client.app.activity.HomeActivity;
import io.ashton.async.client.app.activity.WorkActivity;
import io.ashton.async.client.app.activity.async.AsyncActivityManager;
import io.ashton.async.client.app.activity.async.AsyncActivityMapper;
import io.ashton.async.client.app.ioc.provider.AsyncActivityManagerProvider;
import io.ashton.async.client.app.ioc.provider.PlaceControllerProvider;
import io.ashton.async.client.app.ioc.provider.PlaceHistoryHandlerProvider;
import io.ashton.async.client.app.place.AppPlaceHistoryMapper;
import io.ashton.async.client.app.view.HomeView;
import io.ashton.async.client.app.view.HomeViewImpl;
import io.ashton.async.client.app.view.WorkView;
import io.ashton.async.client.app.view.WorkViewImpl;

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
    bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).in(Singleton.class);

    bind(AsyncActivityManager.class).toProvider(AsyncActivityManagerProvider.class).in(Singleton.class);
    bind(AsyncActivityMapper.class).to(AppAsyncActivityMapper.class).in(Singleton.class);

    bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
    bind(WorkView.class).to(WorkViewImpl.class).in(Singleton.class);

    bind(AppPlaceHistoryMapper.class).in(Singleton.class); // This looks like a DUPLICATE - TODO may need to investigate this

    install(new GinFactoryModuleBuilder()
      .implement(HomeActivity.class, HomeActivity.class)
      .implement(WorkActivity.class, WorkActivity.class)
      .build(ActivityFactory.class));
  }

}
