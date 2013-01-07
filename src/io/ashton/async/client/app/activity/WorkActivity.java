package io.ashton.async.client.app.activity;


import io.ashton.async.client.app.view.WorkView;
import io.ashton.async.client.widgets.TestWidget;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class WorkActivity extends AbstractActivity implements WorkView.Presenter {
  private WorkView view;
  private String something;
  private TestWidget test;

  @AssistedInject
  public WorkActivity(WorkView view, TestWidget test, @Assisted String foo){
    this.view = view;
    this.test = test;
    this.something = foo;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    view.setSomething(something);

    panel.setWidget(view.asWidget());
    doWork("ljsdlfjdfljfldfjdlfdj");
  }

  @Override
  public void doWork(String stuff) {
    // TODO Auto-generated method stub
    System.out.println("Do Work: "+stuff);

    Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
      @Override
      public boolean execute() {
//        PopupPanel p = new PopupPanel();
//        p.setWidget(test);
//        p.center();
        return false;
      }
    }, 3500);

  }

}
