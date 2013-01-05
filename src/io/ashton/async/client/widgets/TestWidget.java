package io.ashton.async.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TestWidget extends Composite {

  private static TestWidgetUiBinder uiBinder = GWT.create(TestWidgetUiBinder.class);

  interface TestWidgetUiBinder extends UiBinder<Widget, TestWidget> {
  }

  private TestWidget() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
