package io.ashton.async.client.app.activity;


import io.ashton.async.client.app.view.WorkView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class WorkActivity extends AbstractActivity implements WorkView.Presenter {
  private WorkView view;
  private String something;

  @Inject
  public WorkActivity(WorkView view){
    this.view = view;
    this.something = "asdf";
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


  }

}
