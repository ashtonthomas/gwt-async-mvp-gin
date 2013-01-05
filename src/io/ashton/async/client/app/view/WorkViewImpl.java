package io.ashton.async.client.app.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class WorkViewImpl extends Composite implements WorkView {

  private static WorkViewImplUiBinder uiBinder = GWT.create(WorkViewImplUiBinder.class);

  interface WorkViewImplUiBinder extends UiBinder<Widget, WorkViewImpl> {
  }

  private Presenter listener;
  private String stuff;

  public WorkViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setSomething(String stuff) {
    // TODO Auto-generated method stub
    System.out.println("TODO set: "+stuff);
  }

  @Override
  public void setPresenter(Presenter listener) {
    this.listener = listener;
  }

}
