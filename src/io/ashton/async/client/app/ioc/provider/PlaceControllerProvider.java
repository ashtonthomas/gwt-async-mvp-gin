package io.ashton.async.client.app.ioc.provider;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PlaceControllerProvider implements Provider<PlaceController> {
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
