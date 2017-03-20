package cn.qingchengfit.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.qingchengfit.widgets.utils.MeasureUtils;

/**
 * Created by fb on 2017/3/20.
 */

public class TextViewWithDrawable {

    private Drawable drawable;
    private String text;
    private Context context;
    private int mWidth;

    public TextViewWithDrawable() {
    }

    public void setmWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public void build(List<Object> list, ViewGroup viewGroup, Drawable drawable){
        LinearLayout layout = null;
        for (Object o : list) {
            if (layout == null){
                layout = new LinearLayout(context);
            }
            TextView view = new TextView(context);
            view.setText(String.valueOf(o));
            view.setCompoundDrawables(drawable, null, null, null);
            view.setCompoundDrawablePadding(MeasureUtils.dpToPx(3f, context.getResources()));
            if (mWidth - layout.getWidth() < view.getWidth()){
                layout = new LinearLayout(context);
                viewGroup.addView(layout);
            }
            layout.addView(view);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
            params.setMargins(MeasureUtils.dpToPx(6f, context.getResources()), 0, 0, 0);
            view.setLayoutParams(params);
        }
    }

}
