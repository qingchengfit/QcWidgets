package cn.qingchengfit.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by yangming on 16/11/11.
 */

public class CheckableButton extends RelativeLayout {

    /*选中时字体颜色*/
    private int mTextColorSelect = 0xffffffff;
    /*未选中时字体颜色*/
    private int mTextColorNormal = 0xff999999;
    /*字体大小*/
    private int mTextSize = 14;

    /*选中时checkbox图标*/
    private int mCheckboxIconSelect;
    /*为选中时checkbox图标*/
    private int mCheckboxIconNormal;

    /*选中时控件背景*/
    private int mBackgroundSelect;
    /*文选中时控件背景*/
    private int mBackgroundNormal;

    /*控件显示的文字内容*/
    private String mContent = "";

    private TextView content;
    private CheckBox checkBox;
    private RelativeLayout root;

    /*控件是否选中*/
    private boolean isChecked = false;

    private Context mContext;

    public CheckableButton(Context context) {
        super(context);
        inflate(context, R.layout.qcw_layout_checkable_button, this);
        init(context, null, 0);
        onFinishInflate();
    }

    public CheckableButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.qcw_layout_checkable_button, this);
        init(context, attrs, 0);
        onFinishInflate();

    }

    public CheckableButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.qcw_layout_checkable_button, this);
        init(context, attrs, defStyleAttr);
        onFinishInflate();
    }

    @TargetApi(21)
    public CheckableButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context, R.layout.qcw_layout_checkable_button, this);
        init(context, attrs, defStyleAttr);
        onFinishInflate();
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CheckableButton);

        mTextColorSelect = ta.getColor(R.styleable.CheckableButton_cb_text_select_color, mTextColorSelect);
        mTextColorNormal = ta.getColor(R.styleable.CheckableButton_cb_text_normal_color, mTextColorNormal);

        mTextSize = (int) ta.getDimension(R.styleable.CheckableButton_cb_text_size
                , mTextSize);

        mCheckboxIconSelect = ta.getResourceId(R.styleable.CheckableButton_cb_hook_icon_select, R.drawable.qcw_vector_hook);
        mCheckboxIconNormal = ta.getResourceId(R.styleable.CheckableButton_cb_hook_icon_normal, 0);

        mBackgroundSelect = ta.getResourceId(R.styleable.CheckableButton_cb_background_select, R.drawable.qcw_shape_bgcenter_green);
        mBackgroundNormal = ta.getResourceId(R.styleable.CheckableButton_cb_background_normal, R.drawable.qcw_shape_bgcenter_white);

        mContent = ta.getString(R.styleable.CheckableButton_cb_text_content);

        isChecked = ta.getBoolean(R.styleable.CheckableButton_cb_select, false);
        ta.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        content = (TextView) findViewById(R.id.tv_content);
        checkBox = (CheckBox) findViewById(R.id.cb_hoot);
        root = (RelativeLayout) findViewById(R.id.rl_root);

        content.setText(mContent);
        content.setTextSize(mTextSize);

        root.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.toggle();
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                initComponentRes();
            }
        });
        checkBox.setChecked(isChecked);
    }

    private void initComponentRes() {
        content.setTextColor(checkBox.isChecked() ? mTextColorSelect : mTextColorNormal);
        checkBox.setButtonDrawable(checkBox.isChecked() ? ContextCompat.getDrawable(mContext, mCheckboxIconSelect) : null);
        root.setBackgroundResource(checkBox.isChecked() ? mBackgroundSelect : mBackgroundNormal);
    }

    private boolean isChecked() {
        return isChecked;
    }

    private void setChecked(boolean checked) {
        checkBox.setChecked(checked);
    }

    private void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        checkBox.setOnCheckedChangeListener(listener);
    }

    private void setContent(String contentStr) {
        content.setText(contentStr);
    }
}
