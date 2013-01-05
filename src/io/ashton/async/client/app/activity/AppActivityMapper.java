package io.ashton.async.client.app.activity;

import io.ashton.async.client.app.activity.async.ActivityAsyncProxy;
import io.ashton.async.client.app.place.HomePlace;
import io.ashton.async.client.app.place.WorkPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

public class AppActivityMapper implements ActivityMapper {

  public interface ActivityFactory {
    HomeActivity homeActivity(String name);
    // WorkActivity workActivity(String something);
  }

  @Inject
  private ActivityFactory factory;

  public AppActivityMapper() {
    System.out.println("init AppActivityMapper");
  }

  @Override
  public Activity getActivity(final Place place) {
    System.out.println("Get Acti: " + factory);
    System.out.println("Place: " + place);

    if (place instanceof HomePlace) {
      return new ActivityAsyncProxy() {
        @Override
        protected void doAsync(final RunAsyncCallback callback) {
          GWT.runAsync(callback);
        }

        @Override
        protected Activity createInstance() {
          return factory.homeActivity(((HomePlace) place).getToken());
        }
      };

    } else if (place instanceof WorkPlace) {
      return new ActivityAsyncProxy() {
        @Override
        protected void doAsync(final RunAsyncCallback callback) {
          GWT.runAsync(WorkActivity.class, callback);
        }

        @Override
        protected Activity createInstance() {
          return GWT.create(WorkActivity.class);
//          return new WorkActivity();
          // return factory.workActivity(((WorkPlace) place).getToken());
        }
      };
    }

    return null;
  }

}
