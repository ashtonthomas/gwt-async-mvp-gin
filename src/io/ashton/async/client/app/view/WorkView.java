package io.ashton.async.client.app.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface WorkView extends IsWidget {

  void setSomething(String stuff);

  void setPresenter(Presenter listener);

  public interface Presenter {
    void doWork(String stuff);
  }

}
