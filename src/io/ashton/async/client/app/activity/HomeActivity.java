package io.ashton.async.client.app.activity;

import io.ashton.async.client.app.place.WorkPlace;
import io.ashton.async.client.app.view.HomeView;
import io.ashton.async.shared.SharedConstants;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {
  private String name;
  private HomeView view;
  private PlaceController placeController;

  @AssistedInject
  public HomeActivity(HomeView view, PlaceController placeController,
      @Assisted String name){
    this.view = view;
    this.name = name;
    this.placeController = placeController;
  }


  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    view.setName(name);

    panel.setWidget(view.asWidget());
  }

  @Override
  public String mayStop(){
    return "Please Hold on.....?";

  }

  @Override
  public void doSomething(String foo) {
    // TODO Auto-generated method stub
    System.out.println("SODOMETHING: "+foo);
    placeController.goTo(new WorkPlace(SharedConstants.APP_PLACE_PREFIX_WORK_PREFIX+"-GGGG"));
  }

}
