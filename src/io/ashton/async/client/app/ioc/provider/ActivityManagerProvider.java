package io.ashton.async.client.app.ioc.provider;

import io.ashton.async.client.app.activity.AppActivityMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ActivityManagerProvider implements Provider<ActivityManager> {
  private final AppActivityMapper activityMapper;
  private final EventBus eventBus;

  @Inject
  public ActivityManagerProvider(AppActivityMapper activityMapper, EventBus eventBus){
    this.activityMapper = activityMapper;
    this.eventBus = eventBus;
  }

  @Override
  public ActivityManager get() {
    return new ActivityManager(activityMapper, eventBus);
  }

}