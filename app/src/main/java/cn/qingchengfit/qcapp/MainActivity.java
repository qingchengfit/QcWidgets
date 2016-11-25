package cn.qingchengfit.qcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.qingchengfit.widgets.CheckableButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CheckableButton btn1;
    private CheckableButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (CheckableButton)findViewById(R.id.btn1);
        btn2 = (CheckableButton)findViewById(R.id.btn2);
        btn1.setClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.toggle();
            }
        });
        btn2.setClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.toggle();
            }
        });
//        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                btn2.toggle();
//            }
//        });
//        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                btn1.toggle();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                btn2.toggle();
                break;
            case R.id.btn2:
                btn1.toggle();
                break;
        }
    }
}
