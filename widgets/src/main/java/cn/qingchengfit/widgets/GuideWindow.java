package cn.qingchengfit.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * //  ┏┓　　　┏┓
 * //┏┛┻━━━┛┻┓
 * //┃　　　　　　　┃
 * //┃　　　━　　　┃
 * //┃　┳┛　┗┳　┃
 * //┃　　　　　　　┃
 * //┃　　　┻　　　┃
 * //┃　　　　　　　┃
 * //┗━┓　　　┏━┛
 * //   ┃　　　┃   神兽保佑
 * //   ┃　　　┃   没有bug
 * //   ┃　　　┗━━━┓
 * //   ┃　　　　　　　┣┓
 * //   ┃　　　　　　　┏┛
 * //   ┗┓┓┏━┳┓┏┛
 * //     ┃┫┫　┃┫┫
 * //     ┗┻┛　┗┻┛
 * //
 * //Created by yangming on 16/11/25.
 */

public class GuideWindow {

  public static final int DOWN = 0;
  public static final int UP = 1;

  private Context context;
  private String contentStr;
  private int location;
  private PopupWindow popupWindow;
  private View popview;
  private TextView textView;

  public GuideWindow(Context context, String contentStr, int location) {
    this.context = context;
    this.contentStr = contentStr;
    this.location = location;
    initView();
  }

  public void initView() {
    popupWindow = new PopupWindow(context);
    popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
    popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
    popview = LayoutInflater.from(context).inflate(R.layout.layout_popupwindow, null);
    popupWindow.setContentView(popview);
    popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));

    textView = (TextView) popview.findViewById(R.id.text_content);
    textView.setText(contentStr);
    switch (location) {
      case DOWN:
        textView.setBackgroundResource(R.drawable.qcw_ic_bubble_up);
        break;
      case UP:
        textView.setBackgroundResource(R.drawable.qcw_ic_bubble_down);
        break;
    }
    popupWindow.setOutsideTouchable(false);
    popupWindow.setFocusable(true);
  }

  public void show(View view) {
    popview.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
    int popupWidth = popview.getMeasuredWidth();
    int popupHeight = popview.getMeasuredHeight();
    int vh = view.getMeasuredHeight();
    switch (location) {
      case DOWN:
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        textView.setMaxWidth(w_screen - view.getLeft() - 60);
        popupWindow.showAsDropDown(view, (100 - vh / 2), 0);
        break;
      case UP:
        int x = 0;
        if (vh / 2 < 105) {
          x = popupWidth - 210 - (105 - vh / 2);
        } else {
          x = popupWidth - 210 + (vh / 2 - 105);
        }
        textView.setMaxWidth(view.getRight() - 50);
        popupWindow.showAsDropDown(view, -x, -(popupHeight + vh));

        break;
    }
  }
}
