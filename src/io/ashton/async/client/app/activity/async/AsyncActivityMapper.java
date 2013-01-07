package io.ashton.async.client.app.activity.async;

import com.google.gwt.place.shared.Place;

public interface AsyncActivityMapper {
  void getActivity(Place place, ActivityCallbackHandler activityCallbackHandler);
}
