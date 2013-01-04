package io.ashton.async.client.app.ioc;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public class AppInjectorModule extends  AbstractGinModule {

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);
  }

  class PlaceControllerProvider implements Provider<PlaceController> {
    private final EventBus eventBus;

    @Inject
    public PlaceControllerProvider(EventBus eventBus){
      this.eventBus = eventBus;
    }

    @Override
    public PlaceController get() {
      return new PlaceController(eventBus);
    }

  }

}
