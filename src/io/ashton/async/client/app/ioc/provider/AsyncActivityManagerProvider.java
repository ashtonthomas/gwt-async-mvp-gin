package io.ashton.async.client.app.ioc.provider;

import io.ashton.async.client.app.activity.async.AsyncActivityManager;
import io.ashton.async.client.app.activity.async.AsyncActivityMapper;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AsyncActivityManagerProvider implements Provider<AsyncActivityManager> {
  private final AsyncActivityMapper activityMapper;
  private final EventBus eventBus;

  @Inject
  public AsyncActivityManagerProvider(AsyncActivityMapper activityMapper, EventBus eventBus){
    this.activityMapper = activityMapper;
    this.eventBus = eventBus;
  }

  @Override
  public AsyncActivityManager get() {
    return new AsyncActivityManager(activityMapper, eventBus);
  }

}