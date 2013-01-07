package io.ashton.async.client.app.activity.async;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

public interface ActivityCallbackHandler {
  public void onRecieveActivity(Activity instance, Place linkedPlace);
}
