package io.ashton.async.client.app.activity;


import io.ashton.async.client.app.view.WorkView;
import io.ashton.async.client.app.view.WorkViewImpl;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WorkActivity extends AbstractActivity implements WorkView.Presenter {
  private WorkView view;
  private String something;

  public WorkActivity(){
    this.view = new WorkViewImpl();
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
