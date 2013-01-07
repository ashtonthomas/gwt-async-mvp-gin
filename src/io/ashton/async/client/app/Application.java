package io.ashton.async.client.app;

import io.ashton.async.client.app.activity.async.AsyncActivityManager;
import io.ashton.async.client.widgets.MySPTestWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;


public class Application {

  private EventBus eventBus;
  private PlaceController placeController;
  private PlaceHistoryHandler historyHandler;

  private AsyncActivityManager activityManager;

  @Inject
  public Application(EventBus eventBus, PlaceController placeController,
      PlaceHistoryHandler historyHandler, AsyncActivityManager activityManager){
    this.eventBus = eventBus;
    this.placeController = placeController;
    this.historyHandler = historyHandler;
    this.activityManager = activityManager;
  }

  public void run(){
    Dictionary theme = Dictionary.getDictionary("fooBarTest");
    String foo = theme.get("foo");
    String bar = theme.get("bar");


    VerticalPanel vp = new VerticalPanel();

    vp.add(new InlineLabel("Foo: "+foo));
    vp.add(new InlineLabel("Bar: "+bar));

    Button b = new Button("Click Me", new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        GWT.runAsync(Application.class, new RunAsyncCallback() {
          @Override
          public void onSuccess() {

            String sp3 = "3sp33sp33sp33sp3" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "3sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33sp33s" +
                "p3";
            VerticalPanel vp = new VerticalPanel();
            vp.add(new InlineLabel(sp3));
//            TestWidget t = GWT.create(TestWidget.class);
            MySPTestWidget t = new MySPTestWidget(); // Simple Composite with unique string to test SP
            vp.add(t);
            PopupPanel p = new PopupPanel();
            p.setWidget(vp);
            p.center();


          }
          @Override
          public void onFailure(Throwable reason) {
            Window.alert("SP Application Failed");
          }
        });
      }
    });


    SimplePanel content = new SimplePanel();
    vp.add(content);

    vp.add(b);

    activityManager.setDisplay(content);





    // Don't add to DOM until everything is handled (minimize dom touches?)
    RootPanel.get().add(vp);

    // Handle Current Place on URL or use Default
    historyHandler.handleCurrentHistory();

  }

}
