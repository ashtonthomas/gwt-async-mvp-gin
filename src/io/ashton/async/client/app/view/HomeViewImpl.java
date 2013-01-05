package io.ashton.async.client.app.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeViewImpl extends Composite implements HomeView {

  private static HomeViewImplUiBinder uiBinder = GWT.create(HomeViewImplUiBinder.class);

  interface HomeViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
  }

  @UiField SpanElement nameSpan;
  @UiField Anchor linkFoo;

  private Presenter listener;
  private String name;


  public HomeViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiHandler("linkFoo")
  void onFooBar(ClickEvent event){
    listener.doSomething(name);
  }

  @Override
  public void setName(String name) {
    this.name = name;
    nameSpan.setInnerText(name);
  }

  @Override
  public void setPresenter(Presenter listener) {
    this.listener = listener;
  }

}
