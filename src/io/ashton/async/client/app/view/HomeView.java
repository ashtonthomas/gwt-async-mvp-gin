package io.ashton.async.client.app.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {

  void setName(String name);
  void setPresenter(Presenter listener);

  public interface Presenter {
    void doSomething(String foo);
  }
}
