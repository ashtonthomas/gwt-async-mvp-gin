package io.ashton.async.client.app.activity;

import io.ashton.async.client.app.activity.async.ActivityCallbackHandler;
import io.ashton.async.client.app.activity.async.AsyncActivityMapper;
import io.ashton.async.client.app.place.HomePlace;
import io.ashton.async.client.app.place.WorkPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;

public class AppAsyncActivityMapper implements AsyncActivityMapper {

  public interface ActivityFactory {
    HomeActivity homeActivity(String name);
    // WorkActivity workActivity(String something);
  }

  @Inject
  private ActivityFactory factory;

  public AppAsyncActivityMapper() {
    System.out.println("init AppAsyncActivityMapper");
  }


  @Override
  public void getActivity(final Place place, final ActivityCallbackHandler activityCallbackHandler) {
    System.out.println("Get Acti: " + factory);
    System.out.println("Place: " + place);

    if (place instanceof HomePlace) {
      GWT.runAsync(HomeActivity.class, new RunAsyncCallback() {
        @Override
        public void onSuccess() {
          activityCallbackHandler.onRecieveActivity(factory.homeActivity(((HomePlace) place).getToken()));
        }
        @Override
        public void onFailure(Throwable reason) {
          Window.alert("Fail to load activity");
        }
      });

    } else if (place instanceof WorkPlace) {

      GWT.runAsync(WorkActivity.class, new RunAsyncCallback() {
        @Override
        public void onSuccess() {
          activityCallbackHandler.onRecieveActivity(new WorkActivity());
        }
        @Override
        public void onFailure(Throwable reason) {
          Window.alert("Fail to load activity");
        }
      });


    }

  }

}
