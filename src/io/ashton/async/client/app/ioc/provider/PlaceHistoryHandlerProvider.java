package io.ashton.async.client.app.ioc.provider;

import io.ashton.async.client.app.place.AppPlaceHistoryMapper;
import io.ashton.async.client.app.place.HomePlace;
import io.ashton.async.shared.SharedConstants;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PlaceHistoryHandlerProvider implements Provider<PlaceHistoryHandler> {
  AppPlaceHistoryMapper historyMapper;
  PlaceController placeController;
  EventBus eventBus;

  @Inject
  public PlaceHistoryHandlerProvider(AppPlaceHistoryMapper historyMapper,
      PlaceController placeController, EventBus eventBus){
    this.historyMapper = historyMapper;
    this.placeController = placeController;
    this.eventBus = eventBus;
  }

  @Override
  public PlaceHistoryHandler get() {
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, new HomePlace(SharedConstants.APP_PLACE_PREFIX_HOME_PREFIX+"DEFAULT-FOO"));
    return historyHandler;
  }

}