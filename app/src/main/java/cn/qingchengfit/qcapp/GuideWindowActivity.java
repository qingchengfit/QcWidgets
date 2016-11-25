package cn.qingchengfit.qcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qingchengfit.widgets.GuideWindow;

public class GuideWindowActivity extends AppCompatActivity {

  @BindView(R.id.btn_below) Button btnBelow;
  @BindView(R.id.btn_above) Button btnAbove;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_guide_window);
    ButterKnife.bind(this);
  }

  @OnClick({ R.id.btn_below, R.id.btn_above }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_below:
        GuideWindow guideWindow =
            new GuideWindow(this, "hahahahahahahahahahahahahahahahahaha", GuideWindow.DOWN);
        guideWindow.show(view);
        break;
      case R.id.btn_above:
        GuideWindow guideWindow2 =
            new GuideWindow(this, "hahahahahahahahahahahahahahahahahaha", GuideWindow.UP);
        guideWindow2.show(view);
        break;
    }
  }
}
